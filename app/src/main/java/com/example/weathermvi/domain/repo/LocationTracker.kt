package com.example.weathermvi.domain.repo

import android.location.Location

interface LocationTracker {
    suspend fun getCurrentLocation(): Location?
}