package com.m2s08.m2s08.transport;

import com.m2s08.m2s08.model.Employee;
import com.m2s08.m2s08.model.Register;

import java.util.List;

public record DetailedEmployeeDTO(Long id, String name, String office, Double wage, List<Register> registers) {

    public DetailedEmployeeDTO(Employee employee) {
        this(employee.getId(), employee.getName(), employee.getOffice(), employee.getWage(), employee.getRegisters());
    }
}