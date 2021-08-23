package com.sheyla.mymovies.domain

import com.sheyla.mymovies.domain.usecase.Result

data class WatchList(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)