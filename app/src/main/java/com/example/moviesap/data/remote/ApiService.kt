package com.example.moviesap.data.remote

import com.example.moviesap.model.detail.MovieDetailResponse
import com.example.moviesap.model.movie.MovieResponse
import com.example.moviesap.model.reviews.MovieReviewResponse
import com.example.moviesap.model.videos.MovieVideoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    // Popular
    @GET("movie/popular")
    fun getPopularMovie():Call<MovieResponse>

    // Top rated
    @GET("movie/top_rated")
    fun getTopRatedMovies(): Call<MovieResponse>

    // Details
    @GET("movie/{id}")
    fun getMovieDetails(@Path("id") movieId: Int): Call<MovieDetailResponse>


    // Videos
    @GET("movie/{id}/videos")
    fun getMovieVideos(@Path("id") movieId: Int): Call<MovieVideoResponse>

    // Reviews
    @GET("movie/{id}/reviews")
    fun getMovieReviews(@Path("id") movieId: Int): Call<MovieReviewResponse>
}