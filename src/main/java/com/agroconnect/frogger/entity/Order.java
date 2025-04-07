package com.agroconnect.frogger.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, precision = 10)
    private Double totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status = OrderStatus.PENDING;

    @Column(updatable = false)
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());


    public Order() {

    }

    public Order(User customer, Product product, int quantity, double totalPrice, OrderStatus orderStatus) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status != null ? status : OrderStatus.PROCESSING;  // Default to PENDING if status is null
    }

    public Order(BigInteger customerId, Integer productId, int quantity, double totalPrice, OrderStatus orderStatus) {
    }

    // Getters and Setters
    public BigInteger getId() { return id; }
    public void setId(BigInteger id) { this.id = BigInteger.valueOf(id); }

    public Long getCustomerId() { return customer.getId(); }
    public void setCustomerId(Long id) { this.customer.setId(id); }

    public Long getProductId() { return product.getId(); }
    public void setProductId(BigInteger id) { this.product.setId(id); }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getTotalPrice() { return totalPrice; }
    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

    public OrderStatus getOrderStatus() { return status; }
    public void setOrderStatus(OrderStatus status) { this.status = status; }

    public Timestamp getCreatedAt() { return createdAt; }

}
