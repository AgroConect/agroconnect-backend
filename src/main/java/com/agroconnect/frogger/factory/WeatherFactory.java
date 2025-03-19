package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.WeatherForecast;

import java.time.LocalDate;

public interface WeatherFactory {
    WeatherForecast createWeather(String location, double temperature, double humidity, double precipitation, LocalDate forecastDate, String suggestedCrop);
}
