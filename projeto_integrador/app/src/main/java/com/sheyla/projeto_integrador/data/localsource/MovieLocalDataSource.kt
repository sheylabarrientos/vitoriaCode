package com.sheyla.projeto_integrador.data.localsource

import com.sheyla.projeto_integrador.data.model.movies.MovieResponse
import io.reactivex.Single

interface MovieLocalDataSource {
    fun favoriteMovie(movie: MovieResponse): Single<List<MovieResponse>>
    fun unfavoriteMovie(movie: MovieResponse): Single<List<MovieResponse>>
    fun getFavoriteMovies(): Single<List<MovieResponse>>
    fun checkIfFavorite(movie: MovieResponse): Single<Boolean>
}