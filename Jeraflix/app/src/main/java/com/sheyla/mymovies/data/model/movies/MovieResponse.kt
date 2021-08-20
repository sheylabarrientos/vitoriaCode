package com.sheyla.mymoviesdata.model.movies

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("poster_path")
    val imgHome: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("vote_average")
    val rating: Float,
    @SerializedName("genre_ids")
    val genreIds: List<Int>,
    @SerializedName("")
    var watchedMovie: Boolean = false,
    var isFavorite: Boolean = false,

)
