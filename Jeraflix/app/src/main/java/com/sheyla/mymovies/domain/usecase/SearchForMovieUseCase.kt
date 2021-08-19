package com.sheyla.mymovies.domain.usecase

import android.net.Uri
import com.sheyla.mymovies.data.repository.MoviesRepository
import com.sheyla.mymovies.data.repository.MoviesRepositoryImpl

class SearchForMovieUseCase(private val moviesRepository: MoviesRepository = MoviesRepositoryImpl()) {
    fun executeSearch(movieSearched: Uri) = moviesRepository.searchForMovie(movieSearched)
}