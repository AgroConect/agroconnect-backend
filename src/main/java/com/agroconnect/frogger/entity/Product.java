package com.agroconnect.frogger.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Optional;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false)
    private User farmer;

    @Column(nullable = false, length = 255)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false, precision = 10)
    private Double price;

    @Column(nullable = false)
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private Status status = Status.AVAILABLE;

    @Column(updatable = false)
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    public Product(User farmer, String name, Category category, Double price, int quantity, Status status) {
        this.farmer = farmer;
        this.name = name;
        this.category = category;;
        this.price = price;
        this.quantity = quantity;
        this.status = status != null ? status : Status.AVAILABLE;  // Default to AVAILABLE if status is null
    }

    public Product() {

    }

    // Getters and Setters
    public BigInteger getId() { return id; }
    public void setId(BigInteger id) { this.id = id; }

    public BigInteger getFarmerId() { return farmer.getId(); }
//public BigInteger getFarmerId() {
//    return (farmer != null) ? farmer.getId() : null;
//}
    public void setFarmerId(BigInteger id) { this.farmer.setId(id); }


    public BigInteger getFarmer() {
        return getFarmerId();
    }
    public void setFarmer(User farmer) {
        this.farmer = farmer;
    }

//    public BigInteger getFarmerId() {
//        return (farmer != null) ? farmer.getId() : null;  // Avoids NullPointerException
//    }
//
//    public void setFarmerId(Optional<User> id) {
//        if (this.farmer == null) {  // Ensure farmer is initialized before setting ID
//            this.farmer = new User();
//        }
//        this.farmer.setId(id);
//    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Timestamp getCreatedAt() { return createdAt; }


}