package com.jafdel.lil.springroom.data.repository;

import com.jafdel.lil.springroom.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, UUID> {

}
