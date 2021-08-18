package com.sheyla.mymoviesdomain.usecase

import com.sheyla.mymovies.data.repository.MoviesRepositoryImpl

class GetGenresUseCase(private val repository: MoviesRepositoryImpl = MoviesRepositoryImpl()) {
    fun executeGenres() = repository.getAllGenres()
}