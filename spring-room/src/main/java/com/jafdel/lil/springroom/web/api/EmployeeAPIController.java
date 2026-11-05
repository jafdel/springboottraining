package com.jafdel.lil.springroom.web.api;

import com.jafdel.lil.springroom.service.EmployeeService;
import com.jafdel.lil.springroom.web.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
public class EmployeeAPIController {
    private final EmployeeService employeeService;

    public EmployeeAPIController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() {
        return this.employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable(name="id") UUID id) {
        return this.employeeService.getEmployeeById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee addEmployee(@RequestBody Employee employee) {
        return this.employeeService.addEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable(name="id") UUID id, @RequestBody Employee employee) {
        return this.employeeService.updateEmployee(employee);
    }

    @DeleteMapping
    public void deleteEmployee(@PathVariable(name="id") UUID id) {
        this.employeeService.deleteEmployee(id);
    }
}
