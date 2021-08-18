package com.sheyla.mymovies.data.mappers

import com.sheyla.mymovies.data.model.categories.GenreResponse
import com.sheyla.mymovies.domain.Genre

class GenreMapper {
    fun map(genresResponseList: List<GenreResponse>): List<Genre> {
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