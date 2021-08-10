package com.sheyla.projeto_integrador.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val imgHome: String? = null,
    val id: Int,
    val title: String? = null,
    val rating: String? = null,
    val genreIds: List<Int>,
    var isFavorite: Boolean = false,
) : Parcelable