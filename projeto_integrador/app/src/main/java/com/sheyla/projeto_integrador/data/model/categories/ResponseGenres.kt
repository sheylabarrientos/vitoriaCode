package com.sheyla.projeto_integrador.data.model.categories

import com.google.gson.annotations.SerializedName

data class ResponseGenres(
    @SerializedName("genres")
    val genres: List<GenreResponse>
)
