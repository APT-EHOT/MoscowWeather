package com.artemiymatchin.moscowweather.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.artemiymatchin.moscowweather.R
import com.artemiymatchin.moscowweather.api.WeatherResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main){

    private val viewModel: MainViewModel by viewModels()
//    private lateinit var binding: MainFragment

    private lateinit var weatherData: WeatherResponse

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding = MainFragmentBinding.bind(view)

    }
}