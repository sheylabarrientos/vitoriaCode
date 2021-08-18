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
                genreIds = it.genreIds,
                isFavorite = it.isFavorite
            )
            movies.add(movie)
        }
        return movies
    }
}