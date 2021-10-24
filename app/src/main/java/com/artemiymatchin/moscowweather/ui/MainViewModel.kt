package com.artemiymatchin.moscowweather.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.artemiymatchin.moscowweather.data.WeatherRepository

class MainViewModel @ViewModelInject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    val weatherData = repository.getWeather()

}