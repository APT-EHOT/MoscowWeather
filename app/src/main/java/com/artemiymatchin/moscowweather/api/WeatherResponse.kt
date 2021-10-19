package com.artemiymatchin.moscowweather.api

import com.artemiymatchin.moscowweather.data.WeatherItem

data class WeatherResponse(
    val results: List<WeatherItem>
)

