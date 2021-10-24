package com.artemiymatchin.moscowweather.api

import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    companion object {
        const val BASE_URL = "http://api.openweathermap.org/data/2.5/"
        const val QUERY_CITY = "Moscow"
        const val CLIENT_ID = "9cc4fb816c8ec8e389ece7e71d8cef8b"
    }

    @GET("forecast")
    fun getWeather(
        @Query("q") q: String,
        @Query("appid") appId: String
    ) : WeatherResponse

}