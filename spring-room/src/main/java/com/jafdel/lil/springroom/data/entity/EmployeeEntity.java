package com.jafdel.lil.springroom.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

enum EmployeePosition {HOUSEKEEPING, FRONT_DESK, SECURITY, CONCIERGE}

@Entity
@Table(name="EMPLOYEES")
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name="EMPLOYEE_ID")
    private UUID employeeId;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Enumerated(STRING)
    @Column(name="POSITION")
    private EmployeePosition position;
}
