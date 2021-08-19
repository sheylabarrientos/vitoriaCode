package com.sheyla.projeto_integrador.data.model.certification

import com.google.gson.annotations.SerializedName

class ReleaseDatesResponse(
    @SerializedName("certification")
    val certification: String,
    @SerializedName("type")
    val type: Int) {
}