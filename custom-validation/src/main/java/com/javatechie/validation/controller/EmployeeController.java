package com.javatechie.validation.controller;

import com.javatechie.validation.entity.Employee;
import com.javatechie.validation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/")
    public ResponseEntity<?> saveEmployee(@RequestBody @Valid Employee employee){
        Employee employee1 = service.saveEmployee(employee);
        return  ResponseEntity.status(HttpStatus.OK).body(employee);

    }
}
