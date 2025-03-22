package com.agroconnect.frogger.service;

import com.agroconnect.frogger.entity.Delivery;
import com.agroconnect.frogger.entity.DeliveryStatus;
import com.agroconnect.frogger.factory.DeliveryFactory;
import com.agroconnect.frogger.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

    private final DeliveryFactory deliveryFactory;
    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryService(DeliveryFactory deliveryFactory, DeliveryRepository deliveryRepository) {
        this.deliveryFactory = deliveryFactory;
        this.deliveryRepository = deliveryRepository;
    }

    public Delivery createDelivery(Integer orderId, Integer deliverymanId, String thirdPartyService, String status) {
        // Use the factory to create a new Delivery object
        Delivery delivery = deliveryFactory.createDelivery(orderId, deliverymanId, thirdPartyService, status);
        return deliveryRepository.save(delivery);  // Save it to the database
    }

    public Delivery updateDeliveryStatus(Integer deliveryId, String status) {
        Delivery delivery = deliveryRepository.findById(Long.valueOf(deliveryId))
                .orElseThrow(() -> new RuntimeException("Delivery not found"));
        delivery.setDeliveryStatus(DeliveryStatus.valueOf(status));
        return deliveryRepository.save(delivery);  // Save updated status
    }
}
