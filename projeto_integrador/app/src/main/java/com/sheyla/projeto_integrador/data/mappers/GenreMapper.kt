package com.sheyla.projeto_integrador.data.mappers

import com.sheyla.projeto_integrador.data.model.categories.GenreResponse
import com.sheyla.projeto_integrador.domain.Genre

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