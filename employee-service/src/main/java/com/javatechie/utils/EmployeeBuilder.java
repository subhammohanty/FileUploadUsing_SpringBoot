package com.javatechie.utils;

import com.javatechie.dto.EmployeeDTO;
import com.javatechie.entity.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeBuilder {


    public static List<EmployeeDTO> getListDTO() {
        return Arrays.asList(new EmployeeDTO(10,"Subham" ,"CSE" , 10000),
                new EmployeeDTO(20,"Pritish" ,"QA" , 20000));
    }

    public static List<Employee> getListEntities() {
        return Arrays.asList(new Employee(10,"Subham" ,"CSE" , 10000),
                new Employee(20,"Pritish" ,"QA" , 20000));
    }

    public static EmployeeDTO getDTO() {
        return new EmployeeDTO(10,"Subham" ,"CSE" , 10000);
    }

    public static Employee getEntity() {
        return new Employee(10,"Subham" ,"CSE" , 10000);
    }
}
