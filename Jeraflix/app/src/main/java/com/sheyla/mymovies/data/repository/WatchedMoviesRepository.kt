package com.sheyla.mymovies.data.repository

import com.sheyla.mymovies.domain.Movie
import io.reactivex.Single

interface WatchedMoviesRepository {
    fun addedWatchedList(movie: Movie): Single<List<Movie>>
    fun removedWatchedList(movie:Movie): Single<List<Movie>>
    fun getWatchedMovies(): Single<List<Movie>>
}
