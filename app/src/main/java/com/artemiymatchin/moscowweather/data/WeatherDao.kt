package com.artemiymatchin.moscowweather.data

import androidx.room.*
import io.reactivex.Observable

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather_table")
    fun loadWeatherFromDB(): Observable<List<WeatherItemSimplified>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(weatherItemSimplified: WeatherItemSimplified)

    @Query("DELETE FROM weather_table")
    fun clear()
}