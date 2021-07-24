package com.dio.apiSpring.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dio.apiSpring.dto.WorkPeriodDTO;
import com.dio.apiSpring.entities.WorkPeriod;
import com.dio.apiSpring.repositories.WorkPeriodRepositoy;
import com.dio.apiSpring.services.exceptions.ResourceNotFoundException;

@Service
public class WorkPeriodService {

	@Autowired
	private WorkPeriodRepositoy repository;

	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	public WorkPeriodDTO save(WorkPeriodDTO created) {

		WorkPeriod workPeriod = new WorkPeriod();
		workPeriod.setDescription(created.getDescription());
		repository.save(workPeriod);
		return modelMapper.map(workPeriod, WorkPeriodDTO.class);
	}

	@Transactional(readOnly = true)
	public Page<WorkPeriodDTO> findAllPageable(Pageable pageRequest) {

		Page<WorkPeriod> page = repository.findAll(pageRequest);
		return page.map(x -> modelMapper.map(x, WorkPeriodDTO.class));
	}

	@Transactional(readOnly = true)
	public WorkPeriodDTO findById(Long id) {

		Optional<WorkPeriod> obj = repository.findById(id);
		WorkPeriod result = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return modelMapper.map(result, WorkPeriodDTO.class);
	}

	@Transactional
    public WorkPeriodDTO updateWotkPeriod(Long id, WorkPeriodDTO updated){
        
		try {
			WorkPeriod workPeriod = repository.getById(id);
			workPeriod.setDescription(updated.getDescription());
			return modelMapper.map(workPeriod, WorkPeriodDTO.class);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity not found");
		}
    }
	
	@Transactional
    public void deleteWorkPeriod(Long id) {
		
		try {
			repository.deleteById(id);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Entity not found");
		}
    }
}

