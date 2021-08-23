package com.sheyla.mymovies.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val id: Int,
    var username: String? = null,
    var adult: Boolean = false,
) : Parcelable