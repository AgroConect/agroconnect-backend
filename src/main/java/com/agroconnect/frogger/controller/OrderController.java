package com.agroconnect.frogger.controller;


import com.agroconnect.frogger.entity.Order;
import com.agroconnect.frogger.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Optional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

//    @PostMapping
//    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
//        return ResponseEntity.ok((Order) orderService.placeOrder(order));
//    }
@PostMapping
public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
    BigInteger customerId = order.getCustomerId();
    BigInteger productId = order.getProductId();
    int quantity = order.getQuantity();

    Order newOrder = orderService.placeOrder(customerId, productId, quantity);
    return ResponseEntity.ok(newOrder);
}

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Order>> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(Optional.ofNullable(orderService.getOrderById(BigInteger.valueOf(id))));
    }
}