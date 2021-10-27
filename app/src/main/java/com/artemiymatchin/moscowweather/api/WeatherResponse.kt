package com.artemiymatchin.moscowweather.api

import android.os.Parcelable
import com.artemiymatchin.moscowweather.data.WeatherItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherResponse(
    val cod: String,
    val message: String,
    val list: List<WeatherItem>
) : Parcelable

