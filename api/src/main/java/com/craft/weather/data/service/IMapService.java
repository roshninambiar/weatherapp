package com.craft.weather.data.service;

import com.craft.weather.data.config.CityGeoData;

import java.util.List;

public interface IMapService {

    public List<CityGeoData> getAllCities();

    public Object getGeocodeForCity(String city);

}
