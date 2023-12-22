package com.m2s08.m2s08.controller;

import com.m2s08.m2s08.service.EmployeeService;
import com.m2s08.m2s08.transport.CreateEmployeeDTO;
import com.m2s08.m2s08.transport.SoldierEmployeeDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<SoldierEmployeeDTO> create(@RequestBody @Valid CreateEmployeeDTO body){
        SoldierEmployeeDTO response = this.employeeService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}