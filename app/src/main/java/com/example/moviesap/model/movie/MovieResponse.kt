package com.example.moviesap.model.movie


import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val results: List<MovieResult>
)