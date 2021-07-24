package com.dio.apiSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.apiSpring.entities.WorkPeriod;

@Repository
public interface WorkPeriodRepositoy extends JpaRepository<WorkPeriod, Long> {

}
