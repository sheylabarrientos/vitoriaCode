package com.sheyla.mymovies.data.repository

import com.sheyla.mymovies.domain.Movie
import io.reactivex.Single

interface FavoriteMoviesRepository {
    fun addToFavoriteMovie(movie: Movie): Single<List<Movie>>
    fun removeFavoriteMovie(movie: Movie): Single<List<Movie>>
    fun getFavoriteMovies(): Single<List<Movie>>
}
