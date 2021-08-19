package com.sheyla.mymovies.presentation.profile

import android.os.Parcelable
import android.widget.TextView
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserProfile(val nome: String) : Parcelable {

}