package com.sheyla.mymovies.data.remotesource

import android.net.Uri
import com.sheyla.mymovies.data.model.user.ResponseUser
import com.sheyla.mymovies.data.model.categories.ResponseCategories
import com.sheyla.mymovies.data.model.certification.ResponseCertification
import com.sheyla.mymovies.data.model.movies.MovieInfoResponse
import com.sheyla.mymovies.data.model.movies.ResponseMovies
import com.sheyla.mymovies.data.model.user.UserResponse
import com.sheyla.mymoviesdata.model.cast.ResponseCast
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesRemoteSource {
    @GET("movie/popular")
    fun getPopularMovies(): Single<ResponseMovies>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId: Int): Single<MovieInfoResponse>

    @GET("search/movie")
    fun searchForMovie(@Query("query") movieSearched: Uri): Single<ResponseMovies>

    @GET("movie/{movie_id}/credits")
    fun getCast(@Path("movie_id") movieId: Int): Single<ResponseCast>

    @GET("genre/movie/list")
    fun getAllGenres(): Single<ResponseCategories>

    @GET("movie/{movie_id}/release_dates")
    fun getCertification(@Path("movie_id") movieId: Int): Single<ResponseCertification>

    @GET("discover/movie")
    fun getMoviesByCategory(@Query("with_genres", encoded = true) categoriesId: String): Single<ResponseMovies>

    @GET("movie/{movie_id}/account_states")
    fun getRateWatchlist(): Single<ResponseUser>
}