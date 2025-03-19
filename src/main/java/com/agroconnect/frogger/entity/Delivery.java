package com.agroconnect.frogger.entity;

import jakarta.persistence.*;
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

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getOrderId() { return order.getId(); }
    public void setOrderId(Long id) { this.order.setId(id); }

    public Long getDeliverymanId() { return deliveryman.getId(); }
    public void setDeliverymanId(Long id) { this.deliveryman.setId(id); }

    public String getThirdPartyService() { return thirdPartyService; }
    public void setThirdPartyService(String thirdPartyService) { this.thirdPartyService = thirdPartyService; }

    public DeliveryStatus getDeliveryStatus() { return status; }
    public void setDeliveryStatus(DeliveryStatus status) { this.status = status; }

    public Timestamp getCreatedAt() { return createdAt; }
}
