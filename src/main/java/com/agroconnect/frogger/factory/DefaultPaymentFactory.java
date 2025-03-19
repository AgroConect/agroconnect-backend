package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Payment;
import com.agroconnect.frogger.entity.PaymentMethod;
import com.agroconnect.frogger.entity.PaymentStatus;
import org.springframework.stereotype.Component;

@Component
public class DefaultPaymentFactory implements PaymentFactory {

    @Override
    public Payment createPayment(Integer orderId, Integer customerId, double amount, String paymentMethod, String status) {
        Payment payment = new Payment();
        payment.setOrderId(Long.valueOf(orderId));
        payment.setCustomerId(Long.valueOf(customerId));
        payment.setTotalAmount(amount);
        payment.setPaymentMethod(PaymentMethod.valueOf(paymentMethod));
        payment.setPaymentStatus(PaymentStatus.valueOf(status));
        return payment;
    }
}
