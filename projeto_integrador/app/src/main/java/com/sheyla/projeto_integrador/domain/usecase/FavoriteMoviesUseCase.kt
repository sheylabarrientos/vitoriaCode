package com.sheyla.projeto_integrador.domain.usecase


import com.sheyla.projeto_integrador.data.repository.FavoriteMoviesRepositoryImpl
import com.sheyla.projeto_integrador.domain.Movie

class FavoriteMoviesUseCase(private val favoriteMoviesRepository: FavoriteMoviesRepositoryImpl = FavoriteMoviesRepositoryImpl()) {

    fun getFavoriteMovies() = favoriteMoviesRepository.getFavoriteMovies()
    fun addToFavoriteMovie(movie: Movie) = favoriteMoviesRepository.addToFavoriteMovie(movie)
    fun removeFavoriteMovie(movie: Movie) = favoriteMoviesRepository.removeFavoriteMovie(movie)
}