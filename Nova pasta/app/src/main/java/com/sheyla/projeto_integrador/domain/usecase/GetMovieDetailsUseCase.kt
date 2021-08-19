package com.sheyla.projeto_integrador.domain.usecase

import com.sheyla.projeto_integrador.data.repository.MoviesRepositoryImpl

class GetMovieDetailsUseCase(private val movieRepository: MoviesRepositoryImpl = MoviesRepositoryImpl()) {
    fun executeMovie(movieId: Int) = movieRepository.getMovieDetails(movieId)
    fun executeCast(movieId: Int) = movieRepository.getCast(movieId)
    fun executeCertification(movieId: Int) = movieRepository.getCertification(movieId)
}