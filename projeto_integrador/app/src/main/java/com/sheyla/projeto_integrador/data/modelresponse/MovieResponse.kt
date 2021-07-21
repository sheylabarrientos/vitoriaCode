package com.sheyla.projeto_integrador.data.modelresponse

data class MovieResponse(
    val page: Int,
    val movies: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)