package com.javatechie.client;

import com.javatechie.dto.Customer;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange("/customer")
public interface CustomerClientService {

    @GetExchange
    List<Customer> getAllCustomers();
}
