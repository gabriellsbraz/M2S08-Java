package com.m2s08.m2s08.service;


import com.m2s08.m2s08.model.Employee;
import com.m2s08.m2s08.model.Register;
import com.m2s08.m2s08.repository.EmployeeRepository;
import com.m2s08.m2s08.transport.CreateEmployeeDTO;
import com.m2s08.m2s08.transport.CreateRegisterdDTO;
import com.m2s08.m2s08.transport.DetailedEmployeeDTO;
import com.m2s08.m2s08.transport.SoldierEmployeeDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.awt.print.Pageable;

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

    public Page<SoldierEmployeeDTO> listAll(Pageable pageable){
        return this.employeeRepository.findAll(pageable).map(SoldierEmployeeDTO::new);
    }


    public DetailedEmployeeDTO getEmployee(Long id) {
        return this.employeeRepository.findById(id).map(DetailedEmployeeDTO::new)
                .orElseThrow(()-> new IllegalArgumentException("Employee with id not found: " + id));
    }

    @Transactional
    public CreateRegisterdDTO createRegister(Long id, CreateRegisterdDTO body) {
        Employee employee = this.employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee with id not found: " + id));

        Register register = new Register(body.type(), employee);
        employee.getRegisters().add(register);

        return new CreateRegisterdDTO(register);
    }
}