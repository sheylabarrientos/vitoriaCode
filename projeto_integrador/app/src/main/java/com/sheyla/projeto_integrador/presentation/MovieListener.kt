package com.sheyla.projeto_integrador.presentation

import com.sheyla.projeto_integrador.domain.Movie

interface MovieListener {
    fun openMovieDetails(movieId: Int)
    fun loadMoviesWithGenre(genreIds: List<Int>)
    fun onFavoriteClickedListener(movie: Movie, isChecked: Boolean)
}