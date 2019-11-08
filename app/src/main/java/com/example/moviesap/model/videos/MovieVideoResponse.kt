package com.example.moviesap.model.videos


import com.google.gson.annotations.SerializedName

data class MovieVideoResponse(
    @SerializedName("movieId")
    val id: Int,
    @SerializedName("movieVideoResults")
    val movieVideoResults: List<MovieVideoResults>
)