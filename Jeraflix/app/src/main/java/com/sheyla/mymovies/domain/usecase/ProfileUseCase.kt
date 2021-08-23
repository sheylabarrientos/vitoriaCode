package com.sheyla.mymovies.domain.usecase

import com.sheyla.mymovies.data.repository.ProfileRepositoryImpl
import com.sheyla.mymovies.domain.User

class ProfileUseCase (private val profileRepository: ProfileRepositoryImpl = ProfileRepositoryImpl()) {

    fun addToProfiles(user: User) = profileRepository.addToProfiles(user)
    fun removeToProfiles(user: User) = profileRepository.removeToProfiles(user)
    fun getProfiles() = profileRepository.getProfiles()
}