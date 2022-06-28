package com.craft.weather.data.controller;

import com.craft.weather.data.config.CityGeoData;
import com.craft.weather.data.service.IMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/map")
public class MapController {

    @Autowired
    IMapService mapService;

    @RequestMapping("/city/all")
    public List<CityGeoData> getAllCities() {
        return mapService.getAllCities();
    }

    @GetMapping(path = "/geocode/{city}")
    public Object getCityGeocode(@PathVariable("city") String city) {
        return mapService.getGeocodeForCity(city.toUpperCase());
    }
}
