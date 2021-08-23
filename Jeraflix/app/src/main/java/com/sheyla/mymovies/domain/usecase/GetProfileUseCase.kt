package com.sheyla.mymovies.domain.usecase

import com.sheyla.mymovies.data.repository.MoviesRepositoryImpl

class GetProfileUseCase (private val profileRepository: MoviesRepositoryImpl = MoviesRepositoryImpl()){
    fun executeProfile() = profileRepository.getRateWatchlist()
}