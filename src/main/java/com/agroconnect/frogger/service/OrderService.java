package com.agroconnect.frogger.service;

import com.agroconnect.frogger.entity.Order;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order placeOrder(Order order);

    List<Order> getAllOrders();

    Optional<Order> findById(BigInteger id);

    Order getOrderById(BigInteger id);

    List<Order> getOrdersByCustomerId(BigInteger id);

//    List<Order> getOrdersByCustomerId(BigInteger customerId);

    Order updateOrderStatus(BigInteger orderId, String status);

    void deleteOrder(BigInteger orderId);

    Order placeOrder(BigInteger customerId, BigInteger productId, int quantity);
}
