package com.sheyla.mymoviesdata.model.cast

import com.google.gson.annotations.SerializedName
import com.sheyla.mymovies.data.model.cast.CastResponse

class ResponseCast(
    @SerializedName("cast")
    val cast: List<CastResponse>
)