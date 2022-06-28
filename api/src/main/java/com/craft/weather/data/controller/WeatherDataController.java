package com.craft.weather.data.controller;

import com.craft.weather.data.model.ForecastResponseModel;
import com.craft.weather.data.service.IWeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/weather")
public class WeatherDataController {

    @Autowired
    IWeatherDataService service;

    @GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAllForecast() {
        return "Hello";
    }

    @GetMapping(path = "/{city}")
    public ForecastResponseModel getForecastForCity(@PathVariable("city") String city) {
        return service.getCityWeatherForecast(city.toUpperCase());
    }

}
