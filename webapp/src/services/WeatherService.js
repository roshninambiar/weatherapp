const axios = require('axios');

const FAVOURITE_CITY_KEY = "favouriteCity";

export function getCityForecast(cityName) {
    const response = axios.get(`http://localhost:8082/api/weather/${cityName}`);
    return response;
}

export function setFavoriteCity(cityName) {
    window.localStorage.setItem(FAVOURITE_CITY_KEY, cityName);
}

export function getFavoriteCity() {
    return window.localStorage.getItem(FAVOURITE_CITY_KEY);
}

export function getCityList() {
    return axios.get(`http://localhost:8082/api/map/city/all`);
}