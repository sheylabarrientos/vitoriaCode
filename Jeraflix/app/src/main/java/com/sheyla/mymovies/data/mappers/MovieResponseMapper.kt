package com.sheyla.mymovies.data.mappers

import com.sheyla.mymovies.domain.Movie
import com.sheyla.mymoviesdata.model.movies.MovieResponse

class MovieResponseMapper {
    fun map(movie: Movie): MovieResponse {
        return MovieResponse(
            imgHome = movie.imgHome,
            id = movie.id,
            title = movie.title,
            rating = movie.rating,
            genreIds = movie.categoryIds,
            isFavorite = movie.inWatchList,
            watchedMovie = movie.watchedMovie,
        )
    }
}