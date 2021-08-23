package com.sheyla.mymovies.data.localsource

import com.sheyla.mymovies.data.model.user.UserResponse
import com.sheyla.mymoviesdata.model.movies.MovieResponse
import io.reactivex.Single
import java.lang.IllegalStateException

object MovieLocalDataSourceImpl : MovieLocalDataSource {

    private val watchedMovie = mutableListOf<MovieResponse>()
    private val favoriteMoviesList = mutableListOf<MovieResponse>()
    private val profileList = mutableListOf<UserResponse>()

    override fun addToProfileList(userResponse: UserResponse): Single<List<UserResponse>> {
        return Single.create { emitter ->
            val result = profileList.add(userResponse)
            if (result) {
                emitter.onSuccess(profileList)
            } else {
                emitter.onError(IllegalStateException())
            }
        }
    }

    override fun removedProfiledList(userResponse: UserResponse): Single<List<UserResponse>> {
        return Single.create { emitter ->
            val profileToRemove = profileList.find {
                it.id == userResponse.id
            }
            val result = profileList.remove(profileToRemove)
            if (result) {
                emitter.onSuccess(profileList)
            } else {
                emitter.onError(IllegalStateException())
            }
        }
    }

    override fun getProfileList(): Single<List<UserResponse>> {
        return Single.create { emitter ->
            emitter.onSuccess(profileList)
        }
    }

    override fun addToWatchedList(movie: MovieResponse): Single<List<MovieResponse>> {
        return Single.create { emitter ->
            val result = watchedMovie.add(movie)
            if (result) {
                emitter.onSuccess(watchedMovie)
            } else {
                emitter.onError(IllegalStateException())
            }
        }
    }

    override fun removedWatchedList(movie: MovieResponse): Single<List<MovieResponse>> {
        return Single.create { emitter ->
            val movieToRemove = watchedMovie.find {
                it.id == movie.id
            }
            val result = watchedMovie.remove(movieToRemove)
            if (result) {
                emitter.onSuccess(watchedMovie)
            } else {
                emitter.onError(IllegalStateException())
            }
        }
    }

    override fun getWatchedMovies(): Single<List<MovieResponse>> {
        return Single.create { emitter ->
            emitter.onSuccess(watchedMovie)
        }
    }


    override fun addToFavoriteMovie(movie: MovieResponse): Single<List<MovieResponse>> {
        return Single.create { emitter ->
            val result = favoriteMoviesList.add(movie)
            if (result) {
                emitter.onSuccess(favoriteMoviesList)
            } else {
                emitter.onError(IllegalStateException())
            }
        }
    }

    override fun removeFavoriteMovie(movie: MovieResponse): Single<List<MovieResponse>> {
        return Single.create { emitter ->
            val movieToRemove = favoriteMoviesList.find {
                it.id == movie.id
            }
            val result = favoriteMoviesList.remove(movieToRemove)
            if (result) {
                emitter.onSuccess(favoriteMoviesList)
            } else {
                emitter.onError(IllegalStateException())
            }
        }
    }

    override fun getFavoriteMovies(): Single<List<MovieResponse>> {
        return Single.create { emitter ->
            emitter.onSuccess(favoriteMoviesList)
        }
    }
}