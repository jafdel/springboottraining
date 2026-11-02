package com.jafdel.lil.springroom.data.entity;

public enum EmployeePosition {
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
