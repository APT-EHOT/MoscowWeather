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

    private fun clearCache() {
        weatherDao.clear()
    }

    private fun tryToFetchWeather() {

        val itemsToInsert = arrayListOf<WeatherItemSimplified>()

        // Multithreading realization using rxJava
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
                    itemsToInsert.add(newWeatherItem)
                }
            }
            .subscribe({
                clearCache()
                for (weatherItem in itemsToInsert)
                    weatherDao.insert(weatherItem) // Access to DB using Room
            }, { e -> e.printStackTrace() })

    }
}

