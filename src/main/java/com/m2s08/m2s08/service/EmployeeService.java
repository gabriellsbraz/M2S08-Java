package com.m2s08.m2s08.service;


import com.m2s08.m2s08.model.Employee;
import com.m2s08.m2s08.repository.EmployeeRepository;
import com.m2s08.m2s08.transport.CreateEmployeeDTO;
import com.m2s08.m2s08.transport.SoldierEmployeeDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public SoldierEmployeeDTO create(CreateEmployeeDTO body) {
        Employee newEmployee = this.employeeRepository.save(new Employee(body));
        return new SoldierEmployeeDTO(newEmployee);
    }
}