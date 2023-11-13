package com.example.weathermvi.domain.model

import com.example.weathermvi.domain.weather.WeatherType
import java.time.LocalDateTime

data class WeatherDataModel(
    val time: LocalDateTime,
    val pressures: Double,
    val humidity: Double,
    val temperaturesCelsius: Double,
    val windSpeeds: Double,
    val weatherType: WeatherType
)
