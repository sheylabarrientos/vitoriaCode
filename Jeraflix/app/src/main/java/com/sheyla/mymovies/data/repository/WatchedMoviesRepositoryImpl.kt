package com.sheyla.mymovies.data.repository

import com.sheyla.mymovies.data.localsource.MovieLocalDataSourceImpl
import com.sheyla.mymovies.data.mappers.MovieMapper
import com.sheyla.mymovies.data.mappers.MovieResponseMapper
import com.sheyla.mymovies.domain.Movie
import io.reactivex.Single

class WatchedMoviesRepositoryImpl: WatchedMoviesRepository {
    private val movieLocalDataSource = MovieLocalDataSourceImpl
    private val movieMapper = MovieMapper()
    private val movieResponseMapper = MovieResponseMapper()

    override fun addedWatchedList(movie: Movie): Single<List<Movie>> {
        val movieMapped = movieResponseMapper.map(movie)
        return movieLocalDataSource
            .addToWatchedList(movieMapped)
            .map{
                movieMapper.map(it)
            }
    }

    override fun removedWatchedList(movie: Movie): Single<List<Movie>> {
        val movieMapped = movieResponseMapper.map(movie)
        return movieLocalDataSource
            .removedWatchedList(movieMapped)
            .map{
                movieMapper.map(it)
            }
    }

    override fun getWatchedMovies(): Single<List<Movie>> {
        return movieLocalDataSource
            .getWatchedMovies()
            .map {
                movieMapper.map(it)
            }
    }
}