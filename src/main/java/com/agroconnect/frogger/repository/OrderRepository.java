package com.agroconnect.frogger.repository;

import com.agroconnect.frogger.entity.Order;
import com.agroconnect.frogger.entity.OrderStatus;
import com.agroconnect.frogger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
//    List<Order> findByCustomerId(Long customerId);   // Get orders by customer
    List<Order> findByCustomer(User customer);
    List<Order> findByStatus(OrderStatus status);        // Get orders by status

    List<Order> findByCustomerId(BigInteger customerId);
}