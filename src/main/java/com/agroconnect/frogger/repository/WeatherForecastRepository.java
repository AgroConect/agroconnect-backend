package com.agroconnect.frogger.repository;

import com.agroconnect.frogger.entity.WeatherForecast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface WeatherForecastRepository extends JpaRepository<WeatherForecast, Long> {
//    List<WeatherForecast> findByLocation(String location);  // Get weather by location
    Optional<WeatherForecast> findByLocation(String location);

}