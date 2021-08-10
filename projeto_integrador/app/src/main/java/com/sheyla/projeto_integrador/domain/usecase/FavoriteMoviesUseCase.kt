package com.sheyla.projeto_integrador.domain.usecase


import com.sheyla.projeto_integrador.data.repository.FavoriteMoviesRepositoryImpl
import com.sheyla.projeto_integrador.domain.Movie

class FavoriteMoviesUseCase(private val favoriteMoviesRepository: FavoriteMoviesRepositoryImpl = FavoriteMoviesRepositoryImpl()) {

    fun getFavoriteMovies() = favoriteMoviesRepository.getFavoriteMovies()
    fun addFavoriteMovie(movie: Movie) = favoriteMoviesRepository.favoriteMovie(movie)
    fun removeFavoriteMovie(movie: Movie) = favoriteMoviesRepository.unfavoriteMovie(movie)
    fun isFavorite(movie: Movie) = favoriteMoviesRepository.checkIfFavorite(movie)
    //devo criar um usecase diferente pra cada uma dessas funções?
}