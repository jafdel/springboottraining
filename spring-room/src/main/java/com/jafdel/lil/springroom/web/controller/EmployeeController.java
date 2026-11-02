package com.jafdel.lil.springroom.web.controller;

import com.jafdel.lil.springroom.data.entity.EmployeeEntity;
import com.jafdel.lil.springroom.data.repository.EmployeeRepository;
import com.jafdel.lil.springroom.web.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    public String getEmployeesPage(Model model) {
        List<EmployeeEntity> employeeEntities = this.employeeRepository.findAll();
        List<Employee> employees = new ArrayList<>(employeeEntities.size());
        employeeEntities.forEach(e -> employees.add(new Employee(e.getEmployeeId(), e.getFirstName(), e.getLastName(), e.getPosition())));
        model.addAttribute("employees", employees);
        return "employees";
    }
}
