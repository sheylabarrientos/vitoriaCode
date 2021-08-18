package com.sheyla.mymovies.data.model.movies

import com.google.gson.annotations.SerializedName
import com.sheyla.mymoviesdata.model.movies.MovieResponse

data class ResponseMovies(
    @SerializedName("results")
    val movieResults: List<MovieResponse>
)
