package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Delivery;
import com.agroconnect.frogger.entity.DeliveryStatus;
import org.springframework.stereotype.Component;

@Component
public class DefaultDeliveryFactory implements DeliveryFactory {

    @Override
    public Delivery createDelivery(Integer orderId, Integer deliverymanId, String thirdPartyService, String status) {
        Delivery delivery = new Delivery();
        delivery.setOrderId(Long.valueOf(orderId));
        delivery.setDeliverymanId(Long.valueOf(deliverymanId));
        delivery.setThirdPartyService(thirdPartyService);
        delivery.setDeliveryStatus(DeliveryStatus.valueOf(status));
        return delivery;
    }
}
