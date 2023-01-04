package com.javatechie.controller;

import com.javatechie.client.CustomerClientService;
import com.javatechie.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer-service")
public class CustomerController {

    @Autowired
    public CustomerClientService service;

    @GetMapping("/rest/customers")
    public List<Customer> getAllCustomers(){
        return service.getAllCustomers();
    }
}
