package com.example.weathermvi.domain.model

data class WeatherModel(
    val weatherDataModelPerDay: Map<Int, List<WeatherDataModel>>,
    val currentWeatherDataModel: WeatherDataModel?
)
