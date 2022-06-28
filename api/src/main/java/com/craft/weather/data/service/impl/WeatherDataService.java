package com.craft.weather.data.service.impl;

import com.craft.weather.data.config.CityGeoData;
import com.craft.weather.data.model.ForecastResponseModel;
import com.craft.weather.data.service.IWeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class WeatherDataService implements IWeatherDataService {

//    String weatherForecastURL = "https://api.openweathermap.org/data/2.5/forecast?lat={lat}&lon={lon}&appid={appid}";
//    String weatherForecastURL = "https://api.weatherbit.io/v2.0/forecast/daily?lat={lat}&lon={lon}&days=7&key=3cce17f12f9d452d9d8fac2a1a4c0c1c";
    String weatherForecastURL = "https://api.weatherbit.io/v2.0/forecast/daily?city={city}&country={country}&days=7&key={key}";

    public ForecastResponseModel getCityWeatherForecast(String city) {
        RestTemplate restTemplate = new RestTemplate();
        log.info("Weather forecast request for city {}", city);
        ResponseEntity<ForecastResponseModel> response = new ResponseEntity<>(new ForecastResponseModel(), HttpStatus.OK);
        try {
            response = restTemplate.getForEntity(buildForecastURL(city), ForecastResponseModel.class);
        } catch (Exception e) {
            log.error("Could not retrieve weather forecast data for city {}", city, e);
        }
        log.info("Response : {} : {} ", city, response.getBody().toString());
        return response.getBody();
    }

    private String buildForecastURL(String city) {
        CityGeoData cityGeoData = CityGeoData.valueOf(city);
        weatherForecastURL = StringUtils.replace(weatherForecastURL, "{country}",  cityGeoData.getCountry());
        return StringUtils.replace(weatherForecastURL, "{city}",  city);
    }


}
