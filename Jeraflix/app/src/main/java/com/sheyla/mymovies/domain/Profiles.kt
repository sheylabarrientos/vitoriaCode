package com.sheyla.mymovies.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profiles (
    val nome: String = " ",
    val uid: String = " " ) : Parcelable
