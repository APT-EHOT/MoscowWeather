package com.artemiymatchin.moscowweather.data

import com.artemiymatchin.moscowweather.api.WeatherApi
import com.artemiymatchin.moscowweather.api.WeatherResponse
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi
) {



    fun getWeather() {

        lateinit var weatherResponse: WeatherResponse

        weatherApi.getWeather(q = WeatherApi.QUERY_CITY, appId = WeatherApi.CLIENT_ID)
            .subscribeOn(Schedulers.io())
            .doOnNext {
                weatherResponse = it
            }
            .subscribe()

    }
}

