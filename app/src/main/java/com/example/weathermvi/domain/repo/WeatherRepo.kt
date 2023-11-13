package com.example.weathermvi.domain.repo

import com.example.weathermvi.domain.util.Resource
import com.example.weathermvi.domain.model.WeatherModel

interface WeatherRepo {
    suspend fun getWeather(lat: Double, long: Double): Resource<WeatherModel>
}