package com.craft.weather.data.controller;

import com.craft.weather.data.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/map")
public class MapController {

    @Autowired
    WeatherDataService weatherDataService;

    @RequestMapping("/city/all")
    public List<String> getAllCities() {
        return weatherDataService.getAllCities();
    }
}
