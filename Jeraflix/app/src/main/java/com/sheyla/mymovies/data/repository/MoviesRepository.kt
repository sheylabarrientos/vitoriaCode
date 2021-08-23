package com.sheyla.mymovies.data.repository

import android.net.Uri
import com.sheyla.mymovies.domain.*
import io.reactivex.Single

interface MoviesRepository {
    fun getPopularMovies(): Single<List<Movie>>
    fun getMovieDetails(movieId: Int): Single<MovieDetail>
    fun getAllGenres(): Single<List<Category>>
    fun getCast(movieId: Int): Single<List<Cast>>
    fun getMoviesByCategory(categoryId: String): Single<List<Movie>>
    fun getCertification(movieId: Int): Single<List<Certification>>?
    fun searchForMovie(movieSearched: Uri): Single<List<Movie>>
    fun getRateWatchlist(): Single<List<AccountStates>>
}