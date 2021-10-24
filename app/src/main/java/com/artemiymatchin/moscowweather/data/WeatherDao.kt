package com.artemiymatchin.moscowweather.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather_table")
    fun loadWeatherFromDB(): Observable<List<WeatherItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherItem: WeatherItem)
}