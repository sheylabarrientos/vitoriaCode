package com.sheyla.projeto_integrador.data.model.categories

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val genreName: String
)


