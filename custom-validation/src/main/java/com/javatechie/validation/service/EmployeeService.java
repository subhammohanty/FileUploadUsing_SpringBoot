package com.javatechie.validation.service;

import com.javatechie.validation.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class EmployeeService {

    public Employee saveEmployee(Employee employee){
        employee.setEmpId(new Random().nextInt());
        return employee;
    }

}
