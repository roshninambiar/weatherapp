package com.craft.weather.data.service.impl;

import com.craft.weather.data.config.CityGeoData;
import com.craft.weather.data.service.IMapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@Slf4j
public class MapService implements IMapService {

    private String geoCodeURL = "https://api.openweathermap.org/geo/1.0/direct?q={city}&appid={appid}";
    @Override
    public List<CityGeoData> getAllCities() {
        Map<Integer, String> cityData = new HashMap<>();

        List<String> cities = new ArrayList<>();
        for (CityGeoData data : CityGeoData.values()) {
            cities.add(data.name());
            cityData.put(data.getId(), data.name());
        }
        return Arrays.asList(CityGeoData.values());
    }
    @Override
    public Object getGeocodeForCity(String city) {
        RestTemplate restTemplate = new RestTemplate();
        log.info(StringUtils.replace(geoCodeURL, "{city}", city));
        ResponseEntity<String> response = restTemplate.getForEntity(StringUtils.replace(geoCodeURL, "{city}", city), String.class);
        return response;
    }

}
