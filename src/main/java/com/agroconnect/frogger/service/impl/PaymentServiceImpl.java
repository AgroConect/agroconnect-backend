package com.agroconnect.frogger.service.impl;

import com.agroconnect.frogger.entity.Payment;
import com.agroconnect.frogger.factory.PaymentFactory;
import com.agroconnect.frogger.repository.PaymentRepository;
import com.agroconnect.frogger.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl extends PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentFactory paymentFactory, PaymentRepository paymentRepository) {
        super(paymentFactory, paymentRepository);
    }

    @Override
    public Payment processPayment(BigInteger orderId, BigInteger customerId, double amount, String paymentMethod) {
        Payment payment = new Payment(orderId, customerId, amount, paymentMethod, "pending");
        return paymentRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(BigInteger id) {
        return paymentRepository.findById(id);
    }
}
