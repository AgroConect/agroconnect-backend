package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.WeatherForecast;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class DefaultWeatherFactory implements WeatherFactory {

    @Override
    public WeatherForecast createWeather(String location, double temperature, double humidity, double precipitation, LocalDate forecastDate, String suggestedCrop) {
        WeatherForecast weatherForecast = new WeatherForecast();
        weatherForecast.setLocation(location);
        weatherForecast.setTemperature(temperature);
        weatherForecast.setHumidity(humidity);
        weatherForecast.setPrecipitation(precipitation);
        weatherForecast.setForecastDate(Date.valueOf(forecastDate));
        weatherForecast.setSuggestedCrop(suggestedCrop);
        return weatherForecast;
    }
}
