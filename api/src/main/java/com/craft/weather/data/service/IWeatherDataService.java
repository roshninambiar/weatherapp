package com.craft.weather.data.service;

public interface IWeatherDataService {

    public Object getCityWeatherForecast(String city);

    public Object getGeocodeForCity(String city);

}
