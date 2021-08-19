package com.sheyla.projeto_integrador.domain.usecase

import android.net.Uri
import com.sheyla.projeto_integrador.data.repository.MoviesRepository
import com.sheyla.projeto_integrador.data.repository.MoviesRepositoryImpl

class SearchForMovieUseCase(private val moviesRepository: MoviesRepository = MoviesRepositoryImpl()) {
    fun executeSearch(movieSearched: Uri) = moviesRepository.searchForMovie(movieSearched)
}