package com.sheyla.projeto_integrador.domain.usecase

import com.sheyla.projeto_integrador.data.repository.MoviesRepositoryImpl

class GetAllMoviesUseCase(private val moviesRepository: MoviesRepositoryImpl = MoviesRepositoryImpl()) {
    fun execute() = moviesRepository.getPopularMovies()
}