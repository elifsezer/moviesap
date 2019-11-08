package com.example.moviesap.ui.main.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moviesap.model.movie.MovieResult
import com.example.moviesap.ui.main.MainRepository

class PopularMoviesViewModel : ViewModel() {

    private val repository: MainRepository by lazy { MainRepository() }

    fun getPopularMovies():LiveData<List<MovieResult>>? = repository.getPopularMovies()
}