package com.sheyla.mymovies.onclick

import com.sheyla.mymovies.domain.Movie

interface MovieListener {
    fun openMovieDetails(movieId: Int)
//    fun openDetailProfile(listId: Int)
    fun loadMoviesWithGenre(genreIds: List<Int>)
//    fun onFavoriteClickedListener(movie: Movie, isChecked: Boolean)
    fun onWatchListClickedListener(movie: Movie, isChecked: Boolean)
    fun onWatchedListClickedListener(movie: Movie, isChecked: Boolean)
}