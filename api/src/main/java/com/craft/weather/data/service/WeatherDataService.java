package com.craft.weather.data.service;

import com.craft.weather.data.config.CityGeoData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriBuilder;

@Service
public class WeatherDataService implements IWeatherDataService {

    Logger logger = LoggerFactory.getLogger(WeatherDataService.class);

    String geoCodeURL = "https://api.openweathermap.org/geo/1.0/direct?q={city}&appid=55b6607bcc362b19b8d00359d15ae585";
    String weatherForecastURL = "https://api.openweathermap.org/data/2.5/forecast?lat={lat}&lon={lon}&appid=55b6607bcc362b19b8d00359d15ae585";
    public Object getCityWeatherForecast(String city) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(buildForecastURL(city), String.class);
        return response;
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
}
