package com.agroconnect.frogger.service;

import com.agroconnect.frogger.entity.WeatherForecast;
import com.agroconnect.frogger.factory.WeatherFactory;
import com.agroconnect.frogger.repository.WeatherForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class WeatherForecastService {

    private final WeatherFactory weatherFactory;
    private final WeatherForecastRepository weatherForecastRepository;

    @Autowired
    public WeatherForecastService(WeatherFactory weatherFactory, WeatherForecastRepository weatherForecastRepository) {
        this.weatherFactory = weatherFactory;
        this.weatherForecastRepository = weatherForecastRepository;
    }

    public WeatherForecast createWeather(String location, double temperature, double humidity, double precipitation, LocalDate forecastDate, String suggestedCrop) {
        // Use the factory to create a new WeatherForecast object
        WeatherForecast weatherForecast = weatherFactory.createWeather(location, temperature, humidity, precipitation, forecastDate, suggestedCrop);
        return weatherForecastRepository.save(weatherForecast);  // Save to the database
    }

//    public WeatherForecast getWeatherByLocation(String location) {
//        return weatherForecastRepository.findByLocation(location)
//                .orElseThrow(() -> new RuntimeException("Weather forecast not found for this location"));
//    }
}