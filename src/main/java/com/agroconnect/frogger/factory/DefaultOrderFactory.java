package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Order;
import com.agroconnect.frogger.entity.OrderStatus;
import org.springframework.stereotype.Component;

@Component
public class DefaultOrderFactory implements OrderFactory {

    @Override
    public Order createOrder(int customerId, int productId, int quantity, double totalPrice, String status) {
        Order order = new Order();
        order.setCustomerId((long) customerId);
        order.setProductId((long) productId);
        order.setQuantity(quantity);
        order.setTotalPrice(totalPrice);
        order.setOrderStatus(OrderStatus.valueOf(status));

        return order;
    }
}
