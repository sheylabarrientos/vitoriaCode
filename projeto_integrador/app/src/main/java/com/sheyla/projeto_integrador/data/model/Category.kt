package com.sheyla.projeto_integrador.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val id: Int,
    val name: String): Parcelable
