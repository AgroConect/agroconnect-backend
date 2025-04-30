package com.agroconnect.frogger.entity;

import jakarta.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "weather_forecast")
public class WeatherForecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String location;

    @Column(nullable = false, precision = 5)
    private Double temperature;

    @Column(nullable = false, precision = 5)
    private Double humidity;

    @Column(nullable = false, precision = 5)
    private Double precipitation;

    @Column(nullable = false)
    private Date forecastDate;

    @Column(nullable = false, length = 255)
    private String suggestedCrop; // New field for crop recommendation

    @Column(updatable = false)
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(Double precipitation) {
        this.precipitation = precipitation;
    }

    public LocalDate getForecastDate() {
        return forecastDate.toLocalDate();
    }

    public void setForecastDate(Date forecastDate) {
        this.forecastDate = forecastDate;
    }

    public String getSuggestedCrop() {
        return suggestedCrop;
    }

    public void setSuggestedCrop(String suggestedCrop) {
        this.suggestedCrop = suggestedCrop;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
