package com.artemiymatchin.moscowweather.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.artemiymatchin.moscowweather.R
import com.artemiymatchin.moscowweather.api.WeatherResponse
import com.artemiymatchin.moscowweather.data.WeatherDataState
import com.artemiymatchin.moscowweather.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main){

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentMainBinding
    private lateinit var dataState: WeatherDataState

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        dataState = WeatherDataState.LOADING

        val weatherAdapter = WeatherAdapter()

        binding.apply {
            weatherContainer.apply {
                adapter = weatherAdapter
                layoutManager = LinearLayoutManager(requireContext())
                setHasFixedSize(true)
            }
        }

        updateUI()


        // Multithreading realization using rxJava
        viewModel.weatherData
            .subscribeOn(Schedulers.io())
            .doOnNext {
                weatherAdapter.submitList(it)
            }
            .delay(250, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterNext {
                dataState = if (weatherAdapter.itemCount == 0)
                    WeatherDataState.EMPTYCACHE
                else
                    WeatherDataState.SUCCESS
                updateUI()
            }
            .subscribe()
    }

    private fun updateUI() {
        binding.apply {
            when (dataState) {
                WeatherDataState.LOADING -> {
                    progressBar.isVisible = true
                    textViewEmpty.isVisible = false
                    weatherContainer.isVisible = false
                }
                WeatherDataState.EMPTYCACHE -> {
                    progressBar.isVisible = false
                    textViewEmpty.isVisible = true
                    weatherContainer.isVisible = false
                }
                WeatherDataState.SUCCESS -> {
                    progressBar.isVisible = false
                    textViewEmpty.isVisible = false
                    weatherContainer.isVisible = true
                }
            }
        }
    }
}