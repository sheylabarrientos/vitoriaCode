package com.sheyla.projeto_integrador.data.mappers

import com.sheyla.projeto_integrador.data.model.movies.MovieResponse
import com.sheyla.projeto_integrador.domain.Movie

class MovieResponseMapper {
    fun map(movie: Movie): MovieResponse {
        return MovieResponse(
            imgHome = movie.imgHome,
            id = movie.id,
            title = movie.title,
            rating = movie.rating,
            genreIds = movie.genreIds,
            isFavorite = movie.isFavorite
        )
    }
}