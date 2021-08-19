package com.sheyla.projeto_integrador.data.mappers

import com.sheyla.projeto_integrador.data.model.movies.MovieResponse
import com.sheyla.projeto_integrador.domain.Movie

class MovieMapper {
    fun map(movieResponseList: List<MovieResponse>): List<Movie> {
        val movies = mutableListOf<Movie>()
        movieResponseList.forEach {
            val movie = Movie(
                imgHome = it.imgHome,
                id = it.id,
                title = it.title,
                rating = it.rating,
                genreIds = it.genreIds,
                isFavorite = it.isFavorite
            )
            movies.add(movie)
        }
        return movies
    }
}