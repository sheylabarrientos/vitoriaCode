package com.sheyla.mymovies.data.model.categories

import com.google.gson.annotations.SerializedName

data class ResponseCategories(
    @SerializedName("genres")
    val genres: List<CategoriesResponse>
)
