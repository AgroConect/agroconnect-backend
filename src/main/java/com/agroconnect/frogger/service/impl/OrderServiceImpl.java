package com.agroconnect.frogger.service.impl;


import com.agroconnect.frogger.entity.Order;
import com.agroconnect.frogger.entity.OrderStatus;
import com.agroconnect.frogger.entity.Product;
import com.agroconnect.frogger.entity.User;
import com.agroconnect.frogger.repository.OrderRepository;
import com.agroconnect.frogger.repository.ProductRepository;
import com.agroconnect.frogger.repository.UserRepository;
import com.agroconnect.frogger.service.OrderService;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

//    @Override
//    public Order placeOrder(Order order) {
//        return orderRepository.save(order);
//    }
@Override
public Order placeOrder(Order order) {
    // Fetch real Customer entity
    User customer = userRepository.findById(order.getCustomer().getId())
            .orElseThrow(() -> new RuntimeException("Customer not found"));
    order.setCustomer(customer);

    // Fetch real Product entity
    Product product = productRepository.findById(order.getProduct().getId())
            .orElseThrow(() -> new RuntimeException("Product not found"));
    order.setProduct(product);

    // Set total price safely
    order.setTotalPrice(product.getPrice() * order.getQuantity());

    return orderRepository.save(order);
}
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(BigInteger id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Order> getOrdersByCustomer(BigInteger customerId) {
        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return orderRepository.findByCustomer(customer);
    }

    @Override
    public Order updateOrderStatus(BigInteger orderId, String status) {
        Order order = getOrderById(orderId);
        order.setOrderStatus(OrderStatus.valueOf(status.toUpperCase()));
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(BigInteger orderId) {
        orderRepository.deleteById(orderId);
    }
}
