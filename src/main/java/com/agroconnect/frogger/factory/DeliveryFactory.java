package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Delivery;

public interface DeliveryFactory {
    Delivery createDelivery(Integer orderId, Integer deliverymanId, String thirdPartyService, String status);
}
