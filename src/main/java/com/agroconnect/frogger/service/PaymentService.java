//package com.agroconnect.frogger.service;
//
//import com.agroconnect.frogger.entity.Payment;
//import com.agroconnect.frogger.entity.PaymentStatus;
//import com.agroconnect.frogger.factory.PaymentFactory;
//import com.agroconnect.frogger.repository.PaymentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.math.BigInteger;
//
//@Service
//public class PaymentService {
//
//    private final PaymentFactory paymentFactory;
//    private final PaymentRepository paymentRepository;
//
//    @Autowired
//    public PaymentService(PaymentFactory paymentFactory, PaymentRepository paymentRepository) {
//        this.paymentFactory = paymentFactory;
//        this.paymentRepository = paymentRepository;
//    }
//
//    public Payment createPayment(Integer orderId, Integer customerId, double amount, String paymentMethod, String status) {
//        // Use the factory to create a new Payment object
//        Payment payment = paymentFactory.createPayment(orderId, customerId, amount, paymentMethod, status);
//        return paymentRepository.save(payment);  // Save to the database
//    }
//
//    public Payment updatePaymentStatus(Integer paymentId, String status) {
//        Payment payment = paymentRepository.findById(Long.valueOf(paymentId))
//                .orElseThrow(() -> new RuntimeException("Payment not found"));
//        payment.setPaymentStatus(PaymentStatus.valueOf(status));
//        return paymentRepository.save(payment);  // Save updated status
//    }
//
//    public Payment processPayment(Payment payment) {
//        Long orderId = payment.getOrderId();
//        BigInteger customerId = payment.getCustomerId();
//        double amount = payment.getTotalAmount();
//        String paymentMethod = payment.getPaymentMethod().name();
//        String status = payment.getPaymentStatus().name();
//
//        return createPayment(
//                Math.toIntExact(orderId),
//                Math.toIntExact(customerId.longValue()),
//                amount,
//                paymentMethod,
//                status
//        );
//    }
//}