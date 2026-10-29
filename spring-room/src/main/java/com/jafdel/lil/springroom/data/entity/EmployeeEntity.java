package com.jafdel.lil.springroom.data.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;

enum EmployeePosition {
    HOUSEKEEPING, FRONT_DESK, SECURITY, CONCIERGE;

    public String toString() {
        switch (this) {
            case FRONT_DESK:
                return "Front desk";
            case HOUSEKEEPING:
                return "Housekeeping";
            case SECURITY:
                return "Security";
            case CONCIERGE:
                return "Concierge";
        }
        return "";
    }
}

@Entity
@Table(name="EMPLOYEES")
@Getter
@Setter
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
    @Enumerated(EnumType.STRING)
    @Column(name="POSITION")
    private EmployeePosition position;
}
