package com.sheyla.mymovies.domain

import android.os.Parcelable
import android.text.style.ClickableSpan
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserProfile(
    var name: String? = null,
    var uid: String = "",
): Parcelable

