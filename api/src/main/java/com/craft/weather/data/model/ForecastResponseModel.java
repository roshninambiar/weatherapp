package com.craft.weather.data.model;


import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForecastResponseModel {

    List<TemperatureDetailsModel> data;

    String city_name;

    Long lon;

    String timezone;

    Long lat;

    String country_code;
}
