package com.sheyla.projeto_integrador.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Genre(
    val id: Int,
    val name: String
) : Parcelable {

    fun getDataInfo() { "Nome: $name"}
}