package com.sheyla.mymovies.data.repository

import com.sheyla.mymovies.data.localsource.MovieLocalDataSourceImpl
import com.sheyla.mymovies.data.mappers.MovieMapper
import com.sheyla.mymovies.data.mappers.MovieResponseMapper
import com.sheyla.mymovies.domain.Movie
import io.reactivex.Single

class FavoriteMoviesRepositoryImpl: FavoriteMoviesRepository {
    private val movieLocalDataSource = MovieLocalDataSourceImpl
    private val movieMapper = MovieMapper()
    private val movieResponseMapper = MovieResponseMapper()


    override fun addToFavoriteMovie(movie: Movie): Single<List<Movie>> {
        val movieMapped = movieResponseMapper.map(movie)
        return movieLocalDataSource
            .addToFavoriteMovie(movieMapped)
            .map{
                movieMapper.map(it)
            }
    }

    override fun removeFavoriteMovie(movie: Movie): Single<List<Movie>> {
        val movieMapped = movieResponseMapper.map(movie)
        return movieLocalDataSource
            .removeFavoriteMovie(movieMapped)
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
}