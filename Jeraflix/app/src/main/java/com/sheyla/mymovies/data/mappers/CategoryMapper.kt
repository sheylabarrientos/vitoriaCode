package com.sheyla.mymovies.data.mappers

import com.sheyla.mymovies.data.model.categories.CategoriesResponse
import com.sheyla.mymovies.domain.Category

class CategoryMapper {
    fun map(genresResponseList: List<CategoriesResponse>): List<Category> {
        val genres = mutableListOf<Category>()
        genresResponseList.forEach {
            val genre = Category(
                id = it.id,
                name = it.genreName
            )
            genres.add(genre)
        }
        return genres
    }
}