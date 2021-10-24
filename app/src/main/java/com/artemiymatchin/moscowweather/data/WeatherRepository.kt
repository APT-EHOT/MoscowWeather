package com.artemiymatchin.moscowweather.data

import com.artemiymatchin.moscowweather.api.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi
) {

    fun getWeather() =
        weatherApi.getWeather(q = WeatherApi.QUERY_CITY, appId = WeatherApi.CLIENT_ID)

}