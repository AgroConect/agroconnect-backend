package com.agroconnect.frogger.service.impl;


import com.agroconnect.frogger.entity.Order;
import com.agroconnect.frogger.entity.OrderStatus;
import com.agroconnect.frogger.repository.OrderRepository;
import com.agroconnect.frogger.service.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order placeOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(BigInteger id) {
        return Optional.empty();
    }

    @Override
    public Order getOrderById(BigInteger id) {
        return (Order) orderRepository.getOrdersByCustomerId(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Order> getOrdersByCustomerId(BigInteger customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public Order updateOrderStatus(BigInteger orderId, String status) {
        Order order = getOrderById(orderId);
        order.setOrderStatus(OrderStatus.valueOf(status.toUpperCase())); // assuming string like "COMPLETED"
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(BigInteger orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order placeOrder(BigInteger customerId, BigInteger productId, int quantity) {
        return null;
    }
}