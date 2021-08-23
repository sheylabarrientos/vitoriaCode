package com.sheyla.mymovies.data.localsource

import com.sheyla.mymovies.data.model.user.UserResponse
import com.sheyla.mymoviesdata.model.movies.MovieResponse
import io.reactivex.Single

interface MovieLocalDataSource {
    fun addToFavoriteMovie(movie: MovieResponse): Single<List<MovieResponse>>
    fun removeFavoriteMovie(movie: MovieResponse): Single<List<MovieResponse>>
    fun getFavoriteMovies(): Single<List<MovieResponse>>

    fun addToWatchedList(movie: MovieResponse): Single<List<MovieResponse>>
    fun removedWatchedList(movie: MovieResponse): Single<List<MovieResponse>>
    fun getWatchedMovies(): Single<List<MovieResponse>>

    fun addToProfileList(userResponse: UserResponse): Single<List<UserResponse>>
    fun removedProfiledList(userResponse: UserResponse): Single<List<UserResponse>>
    fun getProfileList(): Single<List<UserResponse>>
}