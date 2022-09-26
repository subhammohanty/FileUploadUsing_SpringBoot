package com.splunk.api.controller;

import com.splunk.api.dto.Order;
import com.splunk.api.service.OrderService;
import com.splunk.api.util.Mapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private OrderService service;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        logger.info("OrderController.placeOrder persist order request : {} " , Mapper.mapToJsonString(order));
        Order addOrder = service.addOrder(order);
        logger.info("OrderController.placeOrder response : {} " , Mapper.mapToJsonString(addOrder));
        return addOrder;
    }

    @GetMapping
    public List<Order> getOrders() {
        List<Order> orders = service.getOrders();
        logger.info("OrderController.getOrders response : {} " , Mapper.mapToJsonString(orders));
        return orders;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        logger.info("OrderController.getOrder get by id :  {} " , id);
        Order order = service.getOrder(id);
        logger.info("OrderController.getOrder response by id : {} " , Mapper.mapToJsonString(order));
        return order;
    }
}
