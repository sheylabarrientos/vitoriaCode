package com.sheyla.projeto_integrador.data.repository

import com.sheyla.projeto_integrador.data.localsource.MovieLocalDataSourceImpl
import com.sheyla.projeto_integrador.data.mappers.MovieMapper
import com.sheyla.projeto_integrador.data.mappers.MovieResponseMapper
import com.sheyla.projeto_integrador.domain.Movie
import io.reactivex.Single

class FavoriteMoviesRepositoryImpl: FavoriteMoviesRepository {
    private val movieLocalDataSource = MovieLocalDataSourceImpl
    private val movieMapper = MovieMapper()
    private val movieResponseMapper = MovieResponseMapper()

    /*override fun favoriteMovie(movie: Movie): Single<Boolean> {
        val movieMapped = movieResponseMapper.map(movie)
        return movieLocalDataSource.favoriteMovie(movieMapped)
    }*/

    override fun favoriteMovie(movie: Movie): Single<List<Movie>> {
        val movieMapped = movieResponseMapper.map(movie)
        return movieLocalDataSource
            .favoriteMovie(movieMapped)
            .map{
                movieMapper.map(it)
            }
    }

    override fun unfavoriteMovie(movie: Movie): Single<List<Movie>> {
        val movieMapped = movieResponseMapper.map(movie)
        return movieLocalDataSource
            .unfavoriteMovie(movieMapped)
            .map {
                movieMapper.map(it)
            }
    }

    override fun getFavoriteMovies(): Single<List<Movie>> {
        return movieLocalDataSource
            .getFavoriteMovies()
            .map {
                movieMapper.map(it)
            }
    }

    override fun checkIfFavorite(movie: Movie): Single<Boolean> {
        TODO("Not yet implemented")
    }
}