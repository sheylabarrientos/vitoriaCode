package com.sheyla.mymovies.domain.usecase

import com.sheyla.mymovies.data.repository.WatchedMoviesRepositoryImpl
import com.sheyla.mymovies.domain.Movie

class WatchedMoviesUseCase(private val watchedMoviesRepository: WatchedMoviesRepositoryImpl = WatchedMoviesRepositoryImpl()) {

    fun getWatchedMovies() = watchedMoviesRepository.getWatchedMovies()
    fun addToWatchedMovie(movie: Movie) = watchedMoviesRepository.addedWatchedList(movie)
    fun deleteWatchedMovie(movie: Movie) = watchedMoviesRepository.removedWatchedList(movie)
}