package com.agroconnect.frogger.service;

import com.agroconnect.frogger.entity.Order;
import com.agroconnect.frogger.entity.OrderStatus;
import com.agroconnect.frogger.entity.Product;
import com.agroconnect.frogger.factory.OrderFactory;
import com.agroconnect.frogger.repository.OrderRepository;
import com.agroconnect.frogger.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service

public class OrderService {
    private final OrderFactory orderFactory;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Autowired
    public OrderService(OrderFactory orderFactory, OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderFactory = orderFactory;
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }

    public Order placeOrder(BigInteger customerId, BigInteger productId, int quantity) {
        Product product = (Product) productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough stock available");
        }

        double totalPrice = product.getPrice() * quantity;
        Order order = orderFactory.createOrder(customerId, productId, quantity, totalPrice, "pending");

        // Reduce product stock
        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByCustomer(Integer customerId) {
        return orderRepository.findByCustomerId(BigInteger.valueOf(customerId));
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(BigInteger id) {
        return orderRepository.findById(Long.valueOf(String.valueOf(id)));
    }

    public Order updateOrderStatus(BigInteger id, String status) {
        Order order = orderRepository.findById(Long.valueOf(String.valueOf(id)))
                .orElseThrow(() -> new RuntimeException("Order not found"));
        order.setOrderStatus(OrderStatus.valueOf(status));

        return orderRepository.save(order);
    }

}

