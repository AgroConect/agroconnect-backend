package com.agroconnect.frogger.service.impl;

import com.agroconnect.frogger.entity.WeatherForecast;
import com.agroconnect.frogger.factory.WeatherFactory;
import com.agroconnect.frogger.repository.WeatherForecastRepository;
import com.agroconnect.frogger.service.WeatherForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WeatherForecastServiceImpl extends WeatherForecastService {

    @Autowired
    private WeatherForecastRepository weatherForecastRepository;

    public WeatherForecastServiceImpl(WeatherFactory weatherFactory, WeatherForecastRepository weatherForecastRepository) {
        super(weatherFactory, weatherForecastRepository);
    }

    @Override
    public List<WeatherForecast> getAllWeatherForecasts() {
        return weatherForecastRepository.findAll();
    }
}
