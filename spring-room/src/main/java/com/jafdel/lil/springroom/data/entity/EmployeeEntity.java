package com.jafdel.lil.springroom.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

@Entity
@Table(name="EMPLOYEES")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    @Column(name="EMPLOYEE_ID")
    private UUID employeeId;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Enumerated(EnumType.STRING)
    @Column(name="POSITION")
    private EmployeePosition position;
}
