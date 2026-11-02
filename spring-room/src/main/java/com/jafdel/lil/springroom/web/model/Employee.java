package com.jafdel.lil.springroom.web.model;

import com.jafdel.lil.springroom.data.entity.EmployeeEntity;
import com.jafdel.lil.springroom.data.entity.EmployeePosition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private UUID employeeId;
    private String firstName;
    private String lastName;
    private EmployeePosition position;
}
