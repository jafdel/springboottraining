package com.jafdel.lil.springroom.service;

import com.jafdel.lil.springroom.data.entity.EmployeeEntity;
import com.jafdel.lil.springroom.data.repository.EmployeeRepository;
import com.jafdel.lil.springroom.web.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = this.employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>(employeeEntities.size());
        employeeEntities.forEach(e -> employees.add(getEmployeeFromEntity(e)));
        return employees;
    }

    public Employee getEmployeeById(UUID id) {
        Optional<EmployeeEntity> employeeEntity = this.employeeRepository.findById(id);
        if (employeeEntity.isEmpty())
            return null;
        else
            return this.getEmployeeFromEntity(employeeEntity.get());
    }

    public Employee addEmployee(Employee employee) {
        EmployeeEntity employeeEntity = this.getEmployeeEntityFromEmployee(employee);
        employeeEntity = this.employeeRepository.save(employeeEntity);
        return this.getEmployeeFromEntity(employeeEntity);
    }

    public Employee updateEmployee(Employee employee) {
        EmployeeEntity employeeEntity = this.getEmployeeEntityFromEmployee(employee);
        employeeEntity = this.employeeRepository.save(employeeEntity);
        return this.getEmployeeFromEntity(employeeEntity);
    }

    public void deleteEmployee(UUID id) {
        this.employeeRepository.deleteById(id);
    }

    private Employee getEmployeeFromEntity(EmployeeEntity employeeEntity) {
        return new Employee(employeeEntity.getEmployeeId(), employeeEntity.getFirstName(), employeeEntity.getLastName(), employeeEntity.getPosition());
    }

    private EmployeeEntity getEmployeeEntityFromEmployee(Employee employee) {
        return new EmployeeEntity(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getPosition());
    }
}
