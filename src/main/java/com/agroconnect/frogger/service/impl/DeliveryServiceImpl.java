package com.agroconnect.frogger.service.impl;

import com.agroconnect.frogger.entity.Delivery;
import com.agroconnect.frogger.entity.DeliveryStatus;
import com.agroconnect.frogger.factory.DeliveryFactory;
import com.agroconnect.frogger.repository.DeliveryRepository;
import com.agroconnect.frogger.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl extends DeliveryService {

    @Autowired
    private DeliveryRepository deliveryRepository;

    public DeliveryServiceImpl(DeliveryFactory deliveryFactory, DeliveryRepository deliveryRepository) {
        super(deliveryFactory, deliveryRepository);
    }

    @Override
    public Delivery createDelivery(BigInteger orderId, BigInteger deliverymanId, String thirdPartyService) {
        Delivery delivery = new Delivery(orderId, deliverymanId, thirdPartyService, "pending");
        return deliveryRepository.save(delivery);
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        return deliveryRepository.findAll();
    }

    @Override
    public Optional<Delivery> getDeliveryById(BigInteger id) {
        return deliveryRepository.findById(id);
    }

    @Override
    public Delivery updateDeliveryStatus(BigInteger id, String status) {
        Optional<Delivery> existingDelivery = deliveryRepository.findById(id);
        if (existingDelivery.isPresent()) {
            Delivery delivery = existingDelivery.get();
            delivery.setDeliveryStatus(DeliveryStatus.valueOf(status));
            return deliveryRepository.save(delivery);
        }
        return null;
    }
}
