package com.example.weathermvi.data.model


import com.google.gson.annotations.SerializedName

data class WeatherDataDto(
    @SerializedName("pressure_msl")
    val pressures: List<Double>,
    @SerializedName("relativehumidity_2m")
    val humidities: List<Double>,
    @SerializedName("temperature_2m")
    val temperatures: List<Double>,
    @SerializedName("time")
    val time: List<String>,
    @SerializedName("weathercode")
    val weatherCodes: List<Int>,
    @SerializedName("windspeed_10m")
    val windSpeeds: List<Double>
)

