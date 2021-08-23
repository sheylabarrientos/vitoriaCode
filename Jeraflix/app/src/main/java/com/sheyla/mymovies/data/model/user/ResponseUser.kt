package com.sheyla.mymovies.data.model

import com.google.gson.annotations.SerializedName

data class ResponseUser {
    @SerializedName("results")
    val profileResults: List<UserResponse>
}