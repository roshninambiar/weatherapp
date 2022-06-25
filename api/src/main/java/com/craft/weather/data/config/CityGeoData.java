package com.craft.weather.data.config;

public enum CityGeoData {

    BRISBANE("Queensland", "-27.4689682", "153.0234991"),
    CANBERRA("Australian Capital Territory", "-35.2975906", "149.1012676"),
    DARWIN("Northern Territory", "-12.46044", "130.8410469"),
    HOBART("Tasmania", "-42.8825088", "147.3281233"),
    MELBOURNE("Victoria", "-37.8142176", "144.9631608"),
    PERTH("Western Australia", "-31.9527121", "115.8604796"),
    SYDNEY("New South Wales", "-33.768528", "150.9568559523945");

    private String state;
    private String lat;
    private String lon;

    CityGeoData(String state, String lat, String lon) {
        this.state = state;
        this.lat = lat;
        this.lon = lon;
    }

    public String getLatitude() {
        return this.lat;
    }

    public String getLongitude() {
        return this.lon;
    }



}
