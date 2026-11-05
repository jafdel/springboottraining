package com.jafdel.lil.springroom.web.controller;

import com.jafdel.lil.springroom.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getEmployeesPage(Model model) {
        model.addAttribute("employees", this.employeeService.getAllEmployees());
        return "employees";
    }
}
