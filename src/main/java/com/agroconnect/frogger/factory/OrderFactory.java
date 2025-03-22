package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Order;

import java.math.BigInteger;

public interface OrderFactory {
    Order createOrder(BigInteger customerId, BigInteger productId, int quantity, double totalPrice, String status);
}
