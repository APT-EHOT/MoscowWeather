package com.artemiymatchin.moscowweather.data

import kotlin.math.round

fun formatDate(stringDate: String): String {
    val monthName = when (stringDate.subSequence(5,7)) {
        "01" -> "January"
        "02" -> "February"
        "03" -> "March"
        "04" -> "April"
        "05" -> "May"
        "06" -> "June"
        "07" -> "July"
        "08" -> "August"
        "09" -> "September"
        "10" -> "October"
        "11" -> "November"
        "12" -> "December"
        else -> "MonthError"
    }
    val date = stringDate.subSequence(8,10)
    val time = stringDate.subSequence(11,16)

    return "$time, $date $monthName"
}

fun formatTemp(temp: Double): String {
    val tempC = round(temp - 273.15)
    return "Temperature: $tempC °C"
}

fun formatPressure(pressure: Double): String {
    val presHg = round(pressure / 10 * 7.50062)
    return "Pressure: $presHg mmHg"
}

fun formatHumidity(humidity: Int): String = "Humidity: $humidity%"

fun formatWeather(weather: String): String = "Weather: $weather"

fun formatWindSpeed(windSpeed: Double): String = "Wind speed: $windSpeed km/h"