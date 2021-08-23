package com.sheyla.mymovies.data.model

import com.google.gson.annotations.SerializedName

class UserResponse {
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    val username: String? = null,
    val adult: Boolean,
}