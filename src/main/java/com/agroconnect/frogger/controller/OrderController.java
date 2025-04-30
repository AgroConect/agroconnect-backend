package com.agroconnect.frogger.controller;


import com.agroconnect.frogger.entity.Order;
import com.agroconnect.frogger.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        return ResponseEntity.ok((Order) orderService.placeOrder(order));
    }
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(BigInteger.valueOf(id)));
    }
}