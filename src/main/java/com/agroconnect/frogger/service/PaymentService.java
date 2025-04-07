package com.agroconnect.frogger.service;

import com.agroconnect.frogger.entity.Payment;
import com.agroconnect.frogger.entity.PaymentStatus;
import com.agroconnect.frogger.factory.PaymentFactory;
import com.agroconnect.frogger.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public abstract class PaymentService {

    private final PaymentFactory paymentFactory;
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentFactory paymentFactory, PaymentRepository paymentRepository) {
        this.paymentFactory = paymentFactory;
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(BigInteger orderId, BigInteger customerId, double amount, String paymentMethod, String status) {
        // Use the factory to create a new Payment object
        Payment payment = paymentFactory.createPayment(orderId, customerId, amount, paymentMethod, status);
        return paymentRepository.save(payment);  // Save to the database
    }

    public Payment updatePaymentStatus(Integer paymentId, String status) {
        Payment payment = paymentRepository.findById(Long.valueOf(paymentId))
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.setPaymentStatus(PaymentStatus.valueOf(status));
        return paymentRepository.save(payment);  // Save updated status
    }

    public Payment processPayment(Payment payment) {
        return payment;
    }

    public abstract Payment processPayment(BigInteger orderId, BigInteger customerId, double amount, String paymentMethod);

    public abstract List<Payment> getAllPayments();

    public abstract Optional<Payment> getPaymentById(BigInteger id);
}