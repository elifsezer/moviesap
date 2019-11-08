package com.example.moviesap.data.remote

import com.example.moviesap.util.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient

object ApiClient {

    fun getApiService(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClient())
            .build()

        return retrofit.create(ApiService::class.java)
    }

    private fun getOkHttpClient(): OkHttpClient
    {
        val client= OkHttpClient.Builder()
        client.addInterceptor(RequestInterceptor())
        return client.build()
    }

}