package com.sheyla.mymovies.data.model.user

import com.google.gson.annotations.SerializedName
import com.sheyla.mymovies.domain.Rated

class UserResponse(
    @SerializedName("id")
    val id: Int,
    var favorite: Boolean = false,
    val rated: Rated,
    @SerializedName("watchlist")
    var watchlist: Boolean
)