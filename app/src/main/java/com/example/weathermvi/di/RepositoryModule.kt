package com.example.weathermvi.di

import com.example.weathermvi.data.repo.WeatherRepoImpl
import com.example.weathermvi.domain.repo.WeatherRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWeatherRepository(weatherRepoImpl: WeatherRepoImpl): WeatherRepo
}