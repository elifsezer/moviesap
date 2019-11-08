package com.example.moviesap.ui.detail.overview

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.moviesap.data.remote.ApiClient
import com.example.moviesap.data.remote.ApiService
import com.example.moviesap.model.detail.MovieDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OverviewRepository {

    private val apiService: ApiService by lazy { ApiClient.getApiService() }

    fun getDetails(movieId: Int): MutableLiveData<MovieDetailResponse> {
        val movieDetailLive:MutableLiveData<MovieDetailResponse> = MutableLiveData()
        apiService.getMovieDetails(movieId).enqueue(object : Callback<MovieDetailResponse> {
            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {

                Log.e("getDetails", t.message)
            }

            override fun onResponse(call: Call<MovieDetailResponse>, response: Response<MovieDetailResponse>) {
                movieDetailLive.value=response.body()
            }
        })
        return movieDetailLive
    }

    fun getMovieDetails() {

    }
}