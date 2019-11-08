package com.example.moviesap.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.moviesap.data.remote.ApiClient
import com.example.moviesap.data.remote.ApiService
import com.example.moviesap.model.movie.MovieResponse
import com.example.moviesap.model.movie.MovieResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepository {
    private val apiService: ApiService by lazy {
        ApiClient.getApiService()
    }

    fun getPopularMovies(): LiveData<List<MovieResult>>? {
        val moviesLiveData: MutableLiveData<List<MovieResult>> = MutableLiveData()
        apiService.getPopularMovie().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("getPopularMovies", t.message)
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                moviesLiveData.value = response.body()?.results
            }

        })
        return moviesLiveData
    }

    fun getTopRatedMovies(): LiveData<List<MovieResult>>? {

        val moviesLiveData: MutableLiveData<List<MovieResult>> = MutableLiveData()
        apiService.getTopRatedMovies().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("getTopRatedPopular",t.message)
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                moviesLiveData.value= response.body()?.results
            }

        })

        return moviesLiveData
    }

}