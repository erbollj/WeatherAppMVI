package com.example.weathermvi.data.repo

import com.example.weathermvi.data.model.toWeatherModel
import com.example.weathermvi.data.remote.WeatherApi
import com.example.weathermvi.domain.model.WeatherModel
import com.example.weathermvi.domain.repo.WeatherRepo
import com.example.weathermvi.domain.util.Resource
import javax.inject.Inject

class WeatherRepoImpl @Inject constructor(
    private val api: WeatherApi
): WeatherRepo {
    override suspend fun getWeather(lat: Double, long: Double): Resource<WeatherModel> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherModel()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "error")
        }
    }
}