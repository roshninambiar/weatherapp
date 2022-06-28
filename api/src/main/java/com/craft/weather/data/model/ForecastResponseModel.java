package com.craft.weather.data.model;


import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForecastResponseModel {

    List<TemperatureDetailsModel> data;

    String city_name;

    String lon;

    String timezone;

    String lat;

    String country_code;

    @Override
    public String toString() {
        return "ForecastResponseModel{" +
                "data=" + data +
                ", city_name='" + city_name + '\'' +
                ", lon=" + lon +
                ", timezone='" + timezone + '\'' +
                ", lat=" + lat +
                ", country_code='" + country_code + '\'' +
                '}';
    }
}
