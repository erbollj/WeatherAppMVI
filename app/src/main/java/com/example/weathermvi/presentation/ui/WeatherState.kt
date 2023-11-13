package com.example.weathermvi.presentation.ui

import com.example.weathermvi.domain.model.WeatherModel

data class WeatherState(
    val weatherModel: WeatherModel? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)