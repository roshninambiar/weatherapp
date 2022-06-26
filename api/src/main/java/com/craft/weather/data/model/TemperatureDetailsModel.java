package com.craft.weather.data.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class TemperatureDetailsModel {
    /*
    "moonrise_ts": 1656273383,
            "wind_cdir": "SE",
            "rh": 44,
            "pres": 1008.9,
            "high_temp": 28.9,
            "sunset_ts": 1656320705,
            "ozone": 243.5,
            "moon_phase": 0.029641,
            "wind_gust_spd": 10.1,
            "snow_depth": 0,
            "clouds": 99,
            "ts": 1656255660,
            "sunrise_ts": 1656279660,
            "app_min_temp": 23.6,
            "wind_spd": 4.2,
            "pop": 0,
            "wind_cdir_full": "southeast",
            "slp": 1011.4,
            "moon_phase_lunation": 0.93,
            "valid_date": "2022-06-27",
            "app_max_temp": 28.5,
            "vis": 24.128,
            "dewpt": 12.8,
            "snow": 0,
            "uv": 2.2,
            "weather": {
                "icon": "c04d",
                "code": 804,
                "description": "Overcast clouds"
            },
            "wind_dir": 142,
            "max_dhi": null,
            "clouds_hi": 52,
            "precip": 0,
            "low_temp": 24.5,
            "max_temp": 28.9,
            "moonset_ts": 1656315183,
            "datetime": "2022-06-27",
            "temp": 26.1,
            "min_temp": 23.7,
            "clouds_mid": 99,
            "clouds_low": 15
     */

    String datetime;
    Float temp;
    Float min_temp;
    Float max_temp;

    Integer precip;
    WeatherModel weather;

    String sunrise_ts;
    String sunset_ts;


}
