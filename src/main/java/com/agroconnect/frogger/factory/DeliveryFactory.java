package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Delivery;

import java.math.BigInteger;

public interface DeliveryFactory {
    Delivery createDelivery(BigInteger orderId, BigInteger deliverymanId, String thirdPartyService, String status);
}
