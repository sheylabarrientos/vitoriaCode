package com.sheyla.mymovies.data.mappers

import com.sheyla.mymovies.domain.Movie
import com.sheyla.mymoviesdata.model.movies.MovieResponse


class MovieMapper {
    fun map(movieResponseList: List<MovieResponse>): List<Movie> {
        val movies = mutableListOf<Movie>()
        movieResponseList.forEach {
            val movie = Movie(
                imgHome = it.imgHome,
                id = it.id,
                title = it.title,
                rating = it.rating,
                categoryIds = it.genreIds,
                inWatchList = it.isFavorite,
                watchedMovie = it.watchedMovie,
            )
            movies.add(movie)
        }
        return movies
    }
}