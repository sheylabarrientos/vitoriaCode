package com.sheyla.mymovies.domain.usecase

import com.sheyla.mymovies.data.repository.MoviesRepositoryImpl

class GetAllMoviesUseCase(private val moviesRepository: MoviesRepositoryImpl = MoviesRepositoryImpl()) {
    fun execute() = moviesRepository.getPopularMovies()
}