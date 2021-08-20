package com.sheyla.mymovies.data.localsource

import com.sheyla.mymoviesdata.model.movies.MovieResponse
import io.reactivex.Single

interface MovieLocalDataSource {
    fun addToFavoriteMovie(movie: MovieResponse): Single<List<MovieResponse>>
    fun removeFavoriteMovie(movie: MovieResponse): Single<List<MovieResponse>>
    fun getFavoriteMovies(): Single<List<MovieResponse>>
    fun addToWatchedList(movie: MovieResponse): Single<List<MovieResponse>>
}