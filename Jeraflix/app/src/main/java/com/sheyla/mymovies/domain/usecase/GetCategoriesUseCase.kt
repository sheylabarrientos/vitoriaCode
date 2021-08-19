package com.sheyla.mymoviesdomain.usecase

import com.sheyla.mymovies.data.repository.MoviesRepositoryImpl

class GetCategoriesUseCase(private val repository: MoviesRepositoryImpl = MoviesRepositoryImpl()) {
    fun executeGenres() = repository.getAllGenres()
}