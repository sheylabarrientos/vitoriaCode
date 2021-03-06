package com.sheyla.mymovies.data.model.movies

import com.google.gson.annotations.SerializedName
import com.sheyla.mymovies.domain.Category

class MovieInfoResponse(
    @SerializedName("backdrop_path")
    val backdrop_path: String? = null,
    @SerializedName("genres")
    val categories: List<Category>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("overview")
    val overview: String? = null,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("runtime")
    val runtime: Int? = null,
    @SerializedName("vote_average")
    val vote_average: Float,
    @SerializedName("title")
    val title: String,
    var isFavorite: Boolean = false,
    var watchedMovie: Boolean = false,
)