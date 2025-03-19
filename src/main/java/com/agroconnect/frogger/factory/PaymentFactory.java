package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Payment;

public interface PaymentFactory {
    Payment createPayment(Integer orderId, Integer customerId, double amount, String paymentMethod, String status);
}
