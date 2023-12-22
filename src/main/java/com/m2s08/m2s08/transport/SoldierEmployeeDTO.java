package com.m2s08.m2s08.transport;

import com.m2s08.m2s08.model.Employee;

public record SoldierEmployeeDTO(Long id, String name, String office, Double wage) {

    public SoldierEmployeeDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getOffice(), employee.getWage());
    }
}