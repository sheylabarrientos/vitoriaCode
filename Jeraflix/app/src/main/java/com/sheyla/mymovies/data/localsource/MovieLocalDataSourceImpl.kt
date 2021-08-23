package com.sheyla.mymovies.data.localsource

import com.sheyla.mymoviesdata.model.movies.MovieResponse
import io.reactivex.Single
import java.lang.IllegalStateException

object MovieLocalDataSourceImpl : MovieLocalDataSource {

    private val watchedMovie = mutableListOf<MovieResponse>()
    private val favoriteMoviesList = mutableListOf<MovieResponse>()

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