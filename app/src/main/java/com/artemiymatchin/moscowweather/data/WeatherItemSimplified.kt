package com.artemiymatchin.moscowweather.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class WeatherItemSimplified(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    // Main info
    val temp: Double,
    val pressure: Double,
    val humidity: Int,

    // Weather info
    val weatherMain: String,

    // Wind info
    val windSpeed: Double,

    val dt_txt: String
)