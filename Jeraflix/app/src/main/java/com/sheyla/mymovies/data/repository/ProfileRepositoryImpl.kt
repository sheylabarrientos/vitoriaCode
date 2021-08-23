package com.sheyla.mymovies.data.repository


import com.sheyla.mymovies.data.localsource.MovieLocalDataSourceImpl
import com.sheyla.mymovies.data.mappers.UserMapper
import com.sheyla.mymovies.data.mappers.UserResponseMapper
import com.sheyla.mymovies.domain.AccountStates
import com.sheyla.mymovies.domain.User
import io.reactivex.Single

class ProfileRepositoryImpl: ProfileRepository {
    private val movieLocalDataSource = MovieLocalDataSourceImpl
    private val userMapper = UserMapper()
    private val userResponseMapper = UserResponseMapper()
    override fun addToProfiles(movie: User): Single<List<User>> {
        TODO("Not yet implemented")
    }

    override fun removeToProfiles(movie: User): Single<List<User>> {
        TODO("Not yet implemented")
    }

    override fun getProfiles(): Single<List<User>> {
        TODO("Not yet implemented")
    }

//    override fun addToProfiles(id: AccountStates): Single<List<AccountStates>> {
//        val userMapped = userResponseMapper.map(id)
//        return movieLocalDataSource
//            .addToProfileList(userMapped)
//            .map{
//                userMapper.map(it)
//            }
//    }
//
//    override fun removeToProfiles(id: AccountStates): Single<List<AccountStates>> {
//        val userMapped = userResponseMapper.map(id)
//        return movieLocalDataSource
//            .removedProfiledList(userMapped)
//            .map {
//                userMapper.map(it)
//            }
//    }
//
//    override fun getProfiles(): Single<List<AccountStates>> {
//        return movieLocalDataSource
//            .getProfileList()
//            .map {
//                userMapper.map(it)
//            }
//    }

}