package com.craft.weather.data.config;

public enum CityGeoData {

    BRISBANE(1, "Queensland", "AU","-27.46794", "153.02809"),
    CANBERRA(2, "Australian Capital Territory", "AU","-35.28346", "149.12807"),
    DARWIN(3, "Northern Territory", "AU","-12.46113", "130.84185"),
    HOBART(4, "Tasmania", "AU","-42.87936", "147.32941"),
    MELBOURNE(5, "Victoria", "AU","-37.814", "144.96332"),
    PERTH(6, "Western Australia", "AU","-31.95224", "115.8614"),
    SYDNEY(7, "New South Wales", "AU","-33.86785", "151.20732");

    private int id;
    private String state;

    private String country;
    private String lat;
    private String lon;

    CityGeoData(int id, String state, String country, String lat, String lon) {
        this.id = id;
        this.state = state;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
    }

    public String getLatitude() {
        return this.lat;
    }

    public String getLongitude() {
        return this.lon;
    }

    public String getCountry() {
        return this.country;
    }

    public Integer getId() {
        return this.id;
    }


}
