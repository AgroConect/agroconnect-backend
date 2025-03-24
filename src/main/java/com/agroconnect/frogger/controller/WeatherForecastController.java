package com.agroconnect.frogger.controller;

import com.agroconnect.frogger.entity.WeatherForecast;
import com.agroconnect.frogger.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherForecastController {
    @Autowired
    private WeatherForecastService weatherForecastService;

    @GetMapping("/{location}")
    public ResponseEntity<WeatherForecast> getWeatherForecast(@PathVariable String location) {
        return ResponseEntity.ok((WeatherForecast) weatherForecastService.getWeatherByLocation(location));
    }
}