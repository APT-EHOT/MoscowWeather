package com.artemiymatchin.moscowweather.data

import androidx.room.Database
import androidx.room.RoomDatabase
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [WeatherItem::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao

    class Callback @Inject constructor(
        private val database: Provider<WeatherDatabase>
    ) : RoomDatabase.Callback()

}