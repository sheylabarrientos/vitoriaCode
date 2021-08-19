package com.sheyla.mymovies.data.repository

import android.net.Uri
import com.sheyla.mymovies.data.localsource.MovieLocalDataSourceImpl
import com.sheyla.mymovies.data.mappers.*
import com.sheyla.mymovies.data.remotesource.MoviesRemoteSource
import com.sheyla.mymovies.domain.*
import com.sheyla.mymovies.mappers.MovieDetailMapper
import io.reactivex.Single

class MoviesRepositoryImpl : MoviesRepository {
    private val moviesRemoteSource: MoviesRemoteSource =
        com.sheyla.mymovies.data.base.Network.getMoviesRemoteSource()
    private val movieLocalDataSource = MovieLocalDataSourceImpl
    private val movieMapper = MovieMapper()
    private val genreMapper = CategoryMapper()
    private val castMapper = CastMapper()
    private val movieDetailMapper = MovieDetailMapper()
    private val certificationMapper = CertificationMapper()

    override fun getPopularMovies(): Single<List<Movie>> {
        return moviesRemoteSource
            .getPopularMovies()
            .flatMap { movieResponseList ->
                movieLocalDataSource
                    .getFavoriteMovies()
                    .map { favoriteMovieList ->
                        movieResponseList.movieResults.forEach { movieResponse ->
                            val result = favoriteMovieList.any { favoriteMovie ->
                                favoriteMovie.id == movieResponse.id
                            }
                            movieResponse.isFavorite = result
                        }
                        movieResponseList.movieResults
                    }
            }
            .map {
                movieMapper.map(it)
            }
    }

    override fun getMovieDetails(movieId: Int): Single<MovieDetail> {
        return moviesRemoteSource
            .getMovieDetails(movieId)
            .flatMap { movieResponse ->
                movieLocalDataSource
                    .getFavoriteMovies()
                    .map { favoriteMovieList ->
                        val result = favoriteMovieList.any { favoriteMovie ->
                            favoriteMovie.id == movieResponse.id
                        }
                        movieResponse.isFavorite = result
                        movieResponse
                    }
            }
            .map {
                movieDetailMapper.map(it)
            }
    }

    override fun getAllGenres(): Single<List<Genre>> {
        return moviesRemoteSource
            .getAllGenres()
            .map {
                genreMapper.map(it.genres)
            }
    }

    override fun getMoviesByGenre(genresId: String): Single<List<Movie>> {
        return moviesRemoteSource
            .getMoviesByGenre(genresId)
            .flatMap { movieResponseList ->
                movieLocalDataSource
                    .getFavoriteMovies()
                    .map { favoriteMovieList ->
                        movieResponseList.movieResults.forEach { movieResponse ->
                            val result = favoriteMovieList.any { favoriteMovie ->
                                favoriteMovie.id == movieResponse.id
                            }
                            movieResponse.isFavorite = result
                        }
                        movieResponseList.movieResults
                    }
            }
            .map {
                movieMapper.map(it)
            }
    }

    override fun getCast(movieId: Int): Single<List<Cast>> {
        return moviesRemoteSource
            .getCast(movieId)
            .map {
                castMapper.map(it.cast)
            }
    }

    override fun getCertification(movieId: Int): Single<List<Certification>> {
        return moviesRemoteSource
            .getCertification(movieId)
            .map {
                val br = it.results.find { certificationResponse ->
                    certificationResponse.region == "BR"
                }
                certificationMapper.map(br?.release_date)
            }
    }

    override fun searchForMovie(movieSearched: Uri): Single<List<Movie>> {
        return moviesRemoteSource
            .searchForMovie(movieSearched)
            .flatMap { movieResponseList ->
                movieLocalDataSource
                    .getFavoriteMovies()
                    .map { favoriteMovieList ->
                        movieResponseList.movieResults.forEach { movieResponse ->
                            val result = favoriteMovieList.any { favoriteMovie ->
                                favoriteMovie.id == movieResponse.id
                            }
                            movieResponse.isFavorite = result
                        }
                        movieResponseList.movieResults
                    }
            }
            .map {
                movieMapper.map(it)
            }
    }

}