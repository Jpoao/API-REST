package com.dio.apiSpring.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dio.apiSpring.dto.WorkPeriodDTO;
import com.dio.apiSpring.services.WorkPeriodService;

@RestController
@RequestMapping(path = "/workPeriod")
public class WorkPeriodController {
	
	@Autowired
	private WorkPeriodService service;

	@PostMapping
	public ResponseEntity<WorkPeriodDTO> createWorkPeriod(@RequestBody WorkPeriodDTO newEntity) {
		newEntity = service.save(newEntity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newEntity.getId())
				.toUri();
		return ResponseEntity.created(uri).body(newEntity);
		
	}
	
	@GetMapping
	public ResponseEntity<Page<WorkPeriodDTO>> WorkPeriodPaged(Pageable page){
		Page<WorkPeriodDTO> result = service.findAllPageable(page);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<WorkPeriodDTO> findById(@PathVariable Long id) {
		WorkPeriodDTO entity = service.findById(id);
		return ResponseEntity.ok().body(entity);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<WorkPeriodDTO> updateEntity(@PathVariable Long id, @RequestBody WorkPeriodDTO updatedEntity) {
		WorkPeriodDTO updated = service.updateWotkPeriod(id, updatedEntity);
		return ResponseEntity.ok().body(updated);
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<WorkPeriodDTO> updateEntity(@PathVariable Long id) {
		service.deleteWorkPeriod(id);
		return ResponseEntity.noContent().build();
		
	}
}
