package com.example.moviesap.model.videos


import com.google.gson.annotations.SerializedName

data class MovieVideoResults(
    @SerializedName("movieId")
    var id: String,
    @SerializedName("key")
    var key: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("site")
    var site: String

)