package com.example.moviesap.ui.detail.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviesap.model.detail.MovieDetailResponse

class OverviewViewModel : ViewModel(){
    private val repository:OverviewRepository by lazy { OverviewRepository() }

    fun getDetails(movieId:Int): LiveData<MovieDetailResponse> = repository.getDetails(movieId)
}