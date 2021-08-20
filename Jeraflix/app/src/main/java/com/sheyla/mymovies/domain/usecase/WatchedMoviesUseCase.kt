package com.sheyla.mymovies.domain.usecase

import com.sheyla.mymovies.data.repository.WatchedMoviesRepositoryImpl
import com.sheyla.mymovies.domain.Movie
import io.reactivex.Single

class WatchedMoviesUseCase(private val watchedMoviesRepository: WatchedMoviesRepositoryImpl = WatchedMoviesRepositoryImpl()) {
    fun addToWatchedMovie(movie: Movie): Single<List<Movie>> = watchedMoviesRepository.addedWatchedList(movie)
}