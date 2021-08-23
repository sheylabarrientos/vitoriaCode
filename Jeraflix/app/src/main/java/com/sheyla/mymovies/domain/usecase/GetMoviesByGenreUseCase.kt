package com.sheyla.mymovies.domain.usecase

import com.sheyla.mymovies.data.repository.MoviesRepositoryImpl

class GetMoviesByGenreUseCase(private val repository: MoviesRepositoryImpl = MoviesRepositoryImpl()) {
    fun executeMoviesByCategory(categoryId: String) = repository.getMoviesByCategory(categoryId)
}