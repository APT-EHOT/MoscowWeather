package com.artemiymatchin.moscowweather.api

import android.os.Parcelable
import com.artemiymatchin.moscowweather.data.WeatherItem
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherResponse(
    val results: List<WeatherItem>
) : Parcelable

