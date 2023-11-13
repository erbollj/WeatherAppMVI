package com.example.weathermvi.data.model

import com.example.weathermvi.domain.weather.WeatherType
import com.example.weathermvi.domain.model.WeatherDataModel
import com.example.weathermvi.domain.model.WeatherModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private data class IndexedWeatherData(
    val index: Int,
    val data: WeatherDataModel
)

fun WeatherDataDto.toWeatherDataModel(): Map<Int, List<WeatherDataModel>> {
    return time.mapIndexed { index, time ->
        val temperature = temperatures[index]
        val weatherCode = weatherCodes[index]
        val windSpeed = windSpeeds[index]
        val pressure = pressures[index]
        val humidity = humidities[index]
            IndexedWeatherData(
                index = index,
                data = WeatherDataModel(
                    time = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME),
                    temperaturesCelsius = temperature,
                    pressures = pressure,
                    windSpeeds = windSpeed,
                    humidity = humidity,
                    weatherType = WeatherType.fromWMO(weatherCode)
                )
            )
    }.groupBy {
        it.index / 24
    }.mapValues {
        it.value.map { it.data }
    }
}

fun WeatherDto.toWeatherModel(): WeatherModel {
    val weatherDataMap = weatherData.toWeatherDataModel()
    val now = LocalDateTime.now()
    val currentWeatherData = weatherDataMap[0]?.find {
        val hour = if(now.minute < 30) now.hour else now.hour + 1
        it.time.hour == hour
    }
    return WeatherModel(
        weatherDataModelPerDay = weatherDataMap,
        currentWeatherDataModel = currentWeatherData
    )
}