package com.sheyla.projeto_integrador.domain.usecase

import com.sheyla.projeto_integrador.data.repository.MoviesRepositoryImpl

class GetGenresUseCase(private val repository: MoviesRepositoryImpl = MoviesRepositoryImpl()) {
    fun executeGenres() = repository.getAllGenres()
}