package com.example.moviesap.model.reviews


import com.google.gson.annotations.SerializedName

data class MovieReviewResponse(
    @SerializedName("movieId")
    val id: Int,

    @SerializedName("movieReviewResults")
    val movieReviewResults: List<MovieReviewResults>
)