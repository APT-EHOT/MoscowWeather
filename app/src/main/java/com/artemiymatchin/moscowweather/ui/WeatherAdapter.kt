package com.artemiymatchin.moscowweather.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.artemiymatchin.moscowweather.data.WeatherItemSimplified
import com.artemiymatchin.moscowweather.databinding.WeatherItemBinding

class WeatherAdapter :
    ListAdapter<WeatherItemSimplified, WeatherAdapter.WeatherViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val binding =
            WeatherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return WeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class WeatherViewHolder(private val binding: WeatherItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weatherItem: WeatherItemSimplified) {
            binding.apply {
                dtField.text = weatherItem.dt_txt
                tempField.text = weatherItem.temp.toString()
                pressureField.text = weatherItem.pressure.toString()
                humidityField.text = weatherItem.humidity.toString()
                weatherField.text = weatherItem.weatherMain
                weatherField.text = weatherItem.windSpeed.toString()
            }
        }
    }


    class DiffCallback : DiffUtil.ItemCallback<WeatherItemSimplified>() {

        override fun areItemsTheSame(
            oldItem: WeatherItemSimplified,
            newItem: WeatherItemSimplified
        ) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: WeatherItemSimplified,
            newItem: WeatherItemSimplified
        ) =
            oldItem == newItem
    }
}