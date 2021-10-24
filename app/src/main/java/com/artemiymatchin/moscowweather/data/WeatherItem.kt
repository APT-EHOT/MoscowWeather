package com.artemiymatchin.moscowweather.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Parcelize
data class WeatherItem(
    val main: Main,
    val weather: List<Weather>,
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
        val main: String
    ) : Parcelable

    @Parcelize
    data class Wind(
        val speed: Double
    ) : Parcelable

}
