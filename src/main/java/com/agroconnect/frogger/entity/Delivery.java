package com.agroconnect.frogger.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

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

    // Getters and Setters
    public BigInteger getId() { return id; }
    public void setId(BigInteger id) { this.id = id; }

    public BigInteger getOrderId() { return order.getId(); }
    public void setOrderId(BigInteger id) { this.order.setId(id); }

    public BigInteger getDeliverymanId() { return deliveryman.getId(); }
    public void setDeliverymanId(BigInteger id) { this.deliveryman.setId(id); }

    public String getThirdPartyService() { return thirdPartyService; }
    public void setThirdPartyService(String thirdPartyService) { this.thirdPartyService = thirdPartyService; }

    public DeliveryStatus getDeliveryStatus() { return status; }
    public void setDeliveryStatus(DeliveryStatus status) { this.status = status; }

    public Timestamp getCreatedAt() { return createdAt; }
}
