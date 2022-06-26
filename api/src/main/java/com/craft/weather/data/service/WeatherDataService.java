package com.craft.weather.data.service;

import com.craft.weather.data.config.CityGeoData;
import com.craft.weather.data.model.ForecastResponseModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherDataService implements IWeatherDataService {

    Logger logger = LoggerFactory.getLogger(WeatherDataService.class);

    String geoCodeURL = "https://api.openweathermap.org/geo/1.0/direct?q={city}&appid={appid}";
//    String weatherForecastURL = "https://api.openweathermap.org/data/2.5/forecast?lat={lat}&lon={lon}&appid={appid}";
    String weatherForecastURL = "https://api.weatherbit.io/v2.0/forecast/daily?lat={lat}&lon={lon}&days=7&key={key}";
    public ForecastResponseModel getCityWeatherForecast(String city) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ForecastResponseModel> response = restTemplate.getForEntity(buildForecastURL(city), ForecastResponseModel.class);
        return response.getBody();
    }

    private String buildForecastURL(String city) {
        CityGeoData cityGeoData = CityGeoData.valueOf(city);
        weatherForecastURL = StringUtils.replace(weatherForecastURL, "{lat}",  cityGeoData.getLatitude());
        return StringUtils.replace(weatherForecastURL, "{lon}",  cityGeoData.getLongitude());
    }

    public Object getGeocodeForCity(String city) {
        RestTemplate restTemplate = new RestTemplate();
        logger.info(StringUtils.replace(geoCodeURL, "{city}", city));
        ResponseEntity<String> response = restTemplate.getForEntity(StringUtils.replace(geoCodeURL, "{city}", city), String.class);
        return response;
    }

    @Override
    public List<String> getAllCities() {
        List<String> cities = new ArrayList<>();
        for (CityGeoData data : CityGeoData.values())
            cities.add(data.name());
        return cities;
    }
}
