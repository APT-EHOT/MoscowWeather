package com.artemiymatchin.moscowweather.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.artemiymatchin.moscowweather.data.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest

class MainViewModel @ViewModelInject constructor(
    private val repository: WeatherRepository
) : ViewModel() {

    val weatherData = repository.getWeather()

}