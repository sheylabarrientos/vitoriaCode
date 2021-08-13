package com.sheyla.projeto_integrador.data.repository

import com.sheyla.projeto_integrador.domain.Movie
import io.reactivex.Single

interface FavoriteMoviesRepository {
    fun addToFavoriteMovie(movie: Movie): Single<List<Movie>>
    fun removeFavoriteMovie(movie: Movie): Single<List<Movie>>
    fun getFavoriteMovies(): Single<List<Movie>>
}
