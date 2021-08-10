package com.sheyla.projeto_integrador.domain.usecase

import com.sheyla.projeto_integrador.data.repository.MoviesRepositoryImpl

class GetMoviesByGenreUseCase(private val repository: MoviesRepositoryImpl = MoviesRepositoryImpl()) {
    fun executeMoviesByGenre(genresId: String) = repository.getMoviesByGenre(genresId)
    //não funciona
}