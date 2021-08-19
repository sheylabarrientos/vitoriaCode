package com.sheyla.mymovies.onclick

import com.sheyla.mymovies.domain.Movie

interface MovieListener {
    fun openMovieDetails(movieId: Int)
    fun loadMoviesWithGenre(genreIds: List<Int>)
    fun onFavoriteClickedListener(movie: Movie, isChecked: Boolean)
}