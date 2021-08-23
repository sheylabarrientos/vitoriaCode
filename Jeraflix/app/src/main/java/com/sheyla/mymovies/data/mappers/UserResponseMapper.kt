package com.sheyla.mymovies.data.mappers

import com.sheyla.mymovies.data.model.user.UserResponse
import com.sheyla.mymovies.domain.AccountStates

class UserResponseMapper {
    fun map(account: AccountStates): UserResponse {
        return UserResponse(
            id = account.id,
            favorite = account.favorite,
            rated = account.rated,
            watchlist = account.watchlist
        )
    }
}