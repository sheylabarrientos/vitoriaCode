package com.sheyla.mymovies.data.repository

import com.sheyla.mymovies.domain.User
import io.reactivex.Single

interface ProfileRepository {
    fun addToProfiles(movie: User): Single<List<User>>
    fun removeToProfiles(movie: User): Single<List<User>>
    fun getProfiles(): Single<List<User>>
}