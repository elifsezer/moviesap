package com.example.moviesap.ui.main.toprated

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviesap.model.movie.MovieResult
import com.example.moviesap.ui.main.MainRepository

class TopRatedMoviesViewModel : ViewModel() {
    private val repository:MainRepository by lazy { MainRepository() }
    fun getTopRatedMovies(): LiveData<List<MovieResult>>? = repository.getTopRatedMovies()
}