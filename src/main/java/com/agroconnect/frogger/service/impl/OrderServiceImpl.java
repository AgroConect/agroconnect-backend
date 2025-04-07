package com.agroconnect.frogger.service.impl;

import com.agroconnect.frogger.entity.Order;
import com.agroconnect.frogger.entity.OrderStatus;
import com.agroconnect.frogger.factory.OrderFactory;
import com.agroconnect.frogger.repository.OrderRepository;
import com.agroconnect.frogger.repository.ProductRepository;
import com.agroconnect.frogger.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl extends OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderFactory orderFactory, OrderRepository orderRepository, ProductRepository productRepository) {
        super(orderFactory, orderRepository, productRepository);
    }

    @Override
    public Order placeOrder(BigInteger customerId, Integer productId, int quantity) {
        double totalPrice = calculateTotalPrice(productId, quantity);
        Order order = new Order(customerId, productId, quantity, totalPrice, OrderStatus.PENDING);
        return orderRepository.save(order);
    }

    private double calculateTotalPrice(Integer productId, int quantity) {
        // Placeholder: Fetch product price from the database
        return quantity * 10.0;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(BigInteger id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order updateOrderStatus(BigInteger id, String status) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();
            order.setOrderStatus(OrderStatus.valueOf(status));
            return orderRepository.save(order);
        }
        return null;
    }
}
