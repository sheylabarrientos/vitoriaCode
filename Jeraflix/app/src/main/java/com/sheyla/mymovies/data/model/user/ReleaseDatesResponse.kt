package com.sheyla.mymovies.data.model.user

import com.google.gson.annotations.SerializedName
import com.sheyla.mymovies.domain.Rated

class ReleaseDatesResponse (
    @SerializedName("id")
    val id: Int,
    @SerializedName("username")
    var favorite: Boolean = false,
    val rated: Rated,
    val watchlist: Boolean = false){
}

