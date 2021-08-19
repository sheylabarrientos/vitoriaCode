package com.sheyla.mymovies.data.mappers

import com.sheyla.mymovies.data.model.categories.CategoriesResponse
import com.sheyla.mymovies.domain.Genre

class CategoryMapper {
    fun map(genresResponseList: List<CategoriesResponse>): List<Genre> {
        val genres = mutableListOf<Genre>()
        genresResponseList.forEach {
            val genre = Genre(
                id = it.id,
                name = it.genreName
            )
            genres.add(genre)
        }
        return genres
    }
}