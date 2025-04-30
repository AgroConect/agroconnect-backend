//package com.agroconnect.frogger.controller;
//
//
//import com.agroconnect.frogger.entity.Payment;
//import com.agroconnect.frogger.service.PaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/payments")
//public class PaymentController {
//    @Autowired
//    private PaymentService paymentService;
//
//    @PostMapping
//    public ResponseEntity<Payment> makePayment(@RequestBody Payment payment) {
//        return ResponseEntity.ok(paymentService.processPayment(payment));
//    }
//}