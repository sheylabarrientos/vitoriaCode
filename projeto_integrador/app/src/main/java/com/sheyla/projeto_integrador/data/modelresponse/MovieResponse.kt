package com.sheyla.projeto_integrador.data.modelresponse

import com.google.gson.annotations.SerializedName
import com.sheyla.projeto_integrador.data.model.Details

data class MovieResponse(
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("results")
    val movies: List<Movie> = listOf(),
    @SerializedName("total_pages")
    val total_pages: Int = 0,
    @SerializedName("total_results")
    val total_results: Int = 0
)

data class ListMovies (
    @SerializedName("results")
    var results : List<Movie>)

data class ListCast (
    @SerializedName("id")
    val id : Int,
    @SerializedName("cast")
    val cast: List<Details>)

data class ListAllMoviesGenres (
    @SerializedName("genres")
    var genres : List<AllMoviesGenres>)