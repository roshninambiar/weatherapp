package com.craft.weather.data.service;

import com.craft.weather.data.model.ForecastResponseModel;

import java.util.List;

public interface IWeatherDataService {

    public ForecastResponseModel getCityWeatherForecast(String city);

    public Object getGeocodeForCity(String city);

    public List<String> getAllCities();

}
