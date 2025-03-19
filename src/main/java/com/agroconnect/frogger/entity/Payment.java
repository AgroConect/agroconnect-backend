package com.agroconnect.frogger.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "customerId", nullable = false)
    private User customer;

    @Column(nullable = false, precision = 10)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status = PaymentStatus.PENDING;

    @Column(updatable = false)
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getOrderId() { return order.getId(); }
    public void setOrderId(Long id) { this.order.setId(id); }

    public Long getCustomerId() { return customer.getId(); }
    public void setCustomerId(Long id) { this.customer.setId(id); }

    public Double getTotalAmount() { return amount; }
    public void setTotalAmount(Double amount) { this.amount = amount; }

    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(PaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }

    public PaymentStatus getPaymentStatus() { return status; }
    public void setPaymentStatus(PaymentStatus status) { this.status = status; }

    public Timestamp getCreatedAt() { return createdAt; }
}
