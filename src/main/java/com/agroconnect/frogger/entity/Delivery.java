package com.agroconnect.frogger.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "deliveryman_id", nullable = true)
    private User deliveryman;

    @Column(nullable = true, length = 100)
    private String thirdPartyService;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status = DeliveryStatus.PENDING;

    @Column(updatable = false)
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    public Delivery(Order order, User deliveryman, String thirdPartyService, DeliveryStatus deliveryStatus) {
        this.order = order;
        this.deliveryman = deliveryman;
        this.thirdPartyService = thirdPartyService;
        this.status = status != null ? status : DeliveryStatus.PENDING;  // Default to PENDING if status is null
    }

    public Delivery() {

    }

    public Delivery(BigInteger orderId, BigInteger deliverymanId, String thirdPartyService, String pending) {
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public BigInteger getOrderId() { return order.getId(); }
    public void setOrderId(BigInteger id) { this.order.setId(id); }

    public Long getDeliverymanId() { return deliveryman.getId(); }
    public void setDeliverymanId(BigInteger id) { this.deliveryman.setId(id); }

    public String getThirdPartyService() { return thirdPartyService; }
    public void setThirdPartyService(String thirdPartyService) { this.thirdPartyService = thirdPartyService; }

    public DeliveryStatus getDeliveryStatus() { return status; }
    public void setDeliveryStatus(DeliveryStatus status) { this.status = status; }

    public Timestamp getCreatedAt() { return createdAt; }
}
