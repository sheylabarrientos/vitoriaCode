package com.sheyla.mymovies.domain.usecase


import com.sheyla.mymovies.data.repository.FavoriteMoviesRepositoryImpl
import com.sheyla.mymovies.domain.Movie

class FavoriteMoviesUseCase(private val favoriteMoviesRepository: FavoriteMoviesRepositoryImpl = FavoriteMoviesRepositoryImpl()) {

    fun getFavoriteMovies() = favoriteMoviesRepository.getFavoriteMovies()
    fun addToFavoriteMovie(movie: Movie) = favoriteMoviesRepository.addToFavoriteMovie(movie)
    fun removeFavoriteMovie(movie: Movie) = favoriteMoviesRepository.removeFavoriteMovie(movie)
}