package com.sheyla.mymovies.data.model.user

import com.google.gson.annotations.SerializedName

data class ResponseUser (
    @SerializedName("results")
    val profileResults: List<UserResponse>
)