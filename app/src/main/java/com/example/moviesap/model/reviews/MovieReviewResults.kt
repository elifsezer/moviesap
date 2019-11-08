package com.example.moviesap.model.reviews

import com.google.gson.annotations.SerializedName


data class MovieReviewResults(
    @SerializedName("movieId")
    val id: String,

    @SerializedName("author")
    val author: String,

    @SerializedName("content")
    val content: String
)