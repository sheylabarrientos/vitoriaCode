package com.sheyla.mymovies.domain

data class AccoutStates(
    val favorite: Boolean,
    val id: Int,
    val rated: Rated,
    val watchlist: Boolean
)