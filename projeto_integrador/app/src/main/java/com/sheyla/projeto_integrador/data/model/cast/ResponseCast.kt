package com.sheyla.projeto_integrador.data.model.cast

import com.google.gson.annotations.SerializedName

class ResponseCast(
    @SerializedName("cast")
    val cast: List<CastResponse>
)