package com.agroconnect.frogger.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

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
    public BigInteger getId() { return id; }
    public void setId(BigInteger id) { this.id = id; }

    public BigInteger getOrderId() { return order.getId(); }
    public void setOrderId(BigInteger id) { this.order.setId(id); }

    public BigInteger getCustomerId() { return customer.getId(); }
    public void setCustomerId(BigInteger id) { this.customer.setId(id); }

    public Double getTotalAmount() { return amount; }
    public void setTotalAmount(Double amount) { this.amount = amount; }

    public PaymentMethod getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(PaymentMethod paymentMethod) { this.paymentMethod = paymentMethod; }

    public PaymentStatus getPaymentStatus() { return status; }
    public void setPaymentStatus(PaymentStatus status) { this.status = status; }

    public Timestamp getCreatedAt() { return createdAt; }
}
