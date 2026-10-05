package com.prabha.ecommerce.controller;

import com.prabha.ecommerce.entity.Order;
import com.prabha.ecommerce.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public Order placeOrder(
            @RequestBody Order order) {

        return service.placeOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {

        return service.getAllOrders();
    }

    @GetMapping("/{userId}")
    public List<Order> getUserOrders(
            @PathVariable Long userId) {

        return service.getUserOrders(userId);
    }

    @PutMapping("/{id}/{status}")
    public Order updateStatus(
            @PathVariable Long id,
            @PathVariable String status) {

        return service.updateStatus(
                id,
                status
        );
    }
}