package com.agroconnect.frogger.repository;

import com.agroconnect.frogger.entity.Delivery;
import com.agroconnect.frogger.entity.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByStatus(DeliveryStatus status);  // Get deliveries by status
}
