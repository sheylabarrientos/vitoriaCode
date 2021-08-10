package com.sheyla.projeto_integrador.data.repository

import com.sheyla.projeto_integrador.domain.Movie
import io.reactivex.Single

interface FavoriteMoviesRepository {
    //fun favoriteMovie(movie: Movie): Single<Boolean>
    fun favoriteMovie(movie: Movie): Single<List<Movie>>
    fun unfavoriteMovie(movie: Movie): Single<List<Movie>>
    fun getFavoriteMovies(): Single<List<Movie>>
    fun checkIfFavorite(movie: Movie): Single<Boolean>
}
