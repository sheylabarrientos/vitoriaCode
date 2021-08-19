package com.sheyla.projeto_integrador.data.model.movies

import com.google.gson.annotations.SerializedName

data class ResponseMovies(
    @SerializedName("results")
    val movieResults: List<MovieResponse>
)
