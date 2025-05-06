package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Payment;

import java.math.BigInteger;

public interface PaymentFactory {
//    Payment createPayment(Integer orderId, Integer customerId, double amount, String paymentMethod, String status);

    Payment createPayment(BigInteger orderId, BigInteger customerId, double amount, String paymentMethod, String status);
}
