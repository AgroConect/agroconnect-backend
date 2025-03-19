package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Order;

public interface OrderFactory {
    Order createOrder(int customerId, int productId, int quantity, double totalPrice, String status);
}
