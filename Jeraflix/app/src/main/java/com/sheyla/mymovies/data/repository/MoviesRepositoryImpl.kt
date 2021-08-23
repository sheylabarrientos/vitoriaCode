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
    private val userMapper = UserMapper()
    private val movieDetailMapper = MovieDetailMapper()
    private val certificationMapper = CertificationMapper()

    override fun getRateWatchlist(): Single<List<AccountStates>> {
        return moviesRemoteSource
            .getRateWatchlist()
            .flatMap { userResponseList ->
                movieLocalDataSource
                    .getProfileList()
                    .map { profileList ->
                        userResponseList.profileResults.forEach { userResponse ->
                            val result = profileList.any { profile ->
                                profile.id == userResponse.id
                            }
                            userResponse.favorite = result
                        }
                        userResponseList.profileResults
                    }

            }
            .map {
                userMapper.map(it)
            }
    }

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

    override fun getAllGenres(): Single<List<Category>> {
        return moviesRemoteSource
            .getAllGenres()
            .map {
                genreMapper.map(it.genres)
            }
    }

    override fun getMoviesByCategory(categoryId: String): Single<List<Movie>> {
        return moviesRemoteSource
            .getMoviesByCategory(categoryId)
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