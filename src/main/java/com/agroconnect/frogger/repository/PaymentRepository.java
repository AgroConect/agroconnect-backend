package com.agroconnect.frogger.repository;

import com.agroconnect.frogger.entity.Order;
import com.agroconnect.frogger.entity.Payment;
import com.agroconnect.frogger.entity.PaymentStatus;
import com.agroconnect.frogger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
//    List<Payment> findByCustomerId(Long customerId);  // Get payments by customer
    List<Payment> findByCustomer(User customer);
    List<Payment> findByStatus(PaymentStatus status);        // Get payments by status
}
