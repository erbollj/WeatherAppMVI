package com.example.weathermvi.presentation.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathermvi.domain.repo.LocationTracker
import com.example.weathermvi.domain.repo.WeatherRepo
import com.example.weathermvi.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repo: WeatherRepo,
    private val locationTracker: LocationTracker
): ViewModel() {

    var state by mutableStateOf(WeatherState())
        private set

    fun loadWeatherInfo() {
        viewModelScope.launch {
            state = state.copy(
                isLoading = true,
                error = null
            )
            locationTracker.getCurrentLocation()?.let {
                when(val result = repo.getWeather(it.latitude, it.longitude)) {
                    is Resource.Success -> {
                        Log.e("erbol", "true: " + result.data )
                        state = state.copy(
                            weatherModel = result.data,
                            isLoading = false,
                            error = null
                        )
                    }
                    is Resource.Error -> {
                        Log.e("erbol", "false: " + result.message )
                        state = state.copy(
                            weatherModel = null,
                            isLoading = false,
                            error = result.message
                        )
                    }

                    else -> {}
                }
            }?: kotlin.run {
                state = state.copy(
                    isLoading = false,
                    error = "Couldn't retrieve location. Make sure to grant permission and enable GPS."
                )
            }
        }
    }

}