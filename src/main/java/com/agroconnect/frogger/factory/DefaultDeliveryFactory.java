package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Delivery;
import com.agroconnect.frogger.entity.DeliveryStatus;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class DefaultDeliveryFactory implements DeliveryFactory {

    @Override
    public Delivery createDelivery(BigInteger orderId, BigInteger deliverymanId, String thirdPartyService, String status) {
        Delivery delivery = new Delivery();
        delivery.setOrderId(orderId);
        delivery.setDeliverymanId(deliverymanId);
        delivery.setThirdPartyService(thirdPartyService);
        delivery.setDeliveryStatus(DeliveryStatus.valueOf(status));
        return delivery;
    }
}
