package com.sheyla.projeto_integrador.data.localsource

import com.sheyla.projeto_integrador.data.model.movies.MovieResponse
import io.reactivex.Single

interface MovieLocalDataSource {
    fun addToFavoriteMovie(movie: MovieResponse): Single<List<MovieResponse>>
    fun removeFavoriteMovie(movie: MovieResponse): Single<List<MovieResponse>>
    fun getFavoriteMovies(): Single<List<MovieResponse>>
}