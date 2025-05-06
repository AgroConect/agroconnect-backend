//package com.agroconnect.frogger.controller;
//
//import com.agroconnect.frogger.entity.WeatherForecast;
//import com.agroconnect.frogger.service.WeatherForecastService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/weather")
//public class WeatherForecastController {
//    @Autowired
//    private WeatherForecastService weatherForecastService;
//
//    @PostMapping
//    public ResponseEntity<WeatherForecast> createWeatherForecast(@RequestBody WeatherForecast weatherRequest) {
//        WeatherForecast newForecast = weatherForecastService.createWeather(
//                weatherRequest.getLocation(),
//                weatherRequest.getTemperature(),
//                weatherRequest.getHumidity(),
//                weatherRequest.getPrecipitation(),
//                weatherRequest.getForecastDate(),
//                weatherRequest.getSuggestedCrop()
//        );
//        return ResponseEntity.ok(newForecast);
//    }
//
//    @GetMapping("/{location}")
//    public ResponseEntity<WeatherForecast> getWeatherForecast(@PathVariable String location) {
//        return ResponseEntity.ok((WeatherForecast) weatherForecastService.getWeatherByLocation(location));
//    }
//}