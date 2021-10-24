package com.artemiymatchin.moscowweather.data

import com.artemiymatchin.moscowweather.api.WeatherApi
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi,
    private val weatherDao: WeatherDao
) {

    fun getWeather(): Observable<List<WeatherItemSimplified>> {
        tryToFetchWeather()
        return weatherDao.loadWeatherFromDB()
    }

    private fun tryToFetchWeather() {

        weatherApi.getWeather(q = WeatherApi.QUERY_CITY, appId = WeatherApi.CLIENT_ID)
            .subscribeOn(Schedulers.io())
            .doOnNext {
                for (weatherItem in it.list) {
                    val newWeatherItem = WeatherItemSimplified(
                        temp = weatherItem.main.temp,
                        pressure = weatherItem.main.pressure,
                        humidity = weatherItem.main.humidity,
                        weatherMain = weatherItem.weather[0].main,
                        windSpeed = weatherItem.wind.speed,
                        dt_txt = weatherItem.dt_txt
                        )
                    weatherDao.insert(newWeatherItem)
                }
            }
            .subscribe()

    }
}

