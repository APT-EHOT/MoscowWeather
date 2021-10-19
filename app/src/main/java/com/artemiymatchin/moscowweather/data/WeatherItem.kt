package com.artemiymatchin.moscowweather.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherItem(
    val main: Main,
    val weather: Weather,
    val wind: Wind,
    val dt_txt: String
) : Parcelable {

    @Parcelize
    data class Main(
        val temp: Double,
        val pressure: Double,
        val humidity: Int
    ) : Parcelable

    @Parcelize
    data class Weather(
        val weatherList: List<WeatherListItem>
    ) : Parcelable {

        @Parcelize
        data class WeatherListItem(
            val main: String
        ) : Parcelable

    }

    @Parcelize
    data class Wind(
        val speed: Double
    ) : Parcelable

}
