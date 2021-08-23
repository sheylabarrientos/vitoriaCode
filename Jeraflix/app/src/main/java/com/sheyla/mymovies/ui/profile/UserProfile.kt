package com.sheyla.mymovies.ui.profile

import android.os.Parcelable
import android.text.style.ClickableSpan
import kotlinx.android.parcel.Parcelize

@Parcelize
class UserProfile(
    var name: String? = null,
    var btn: Boolean = false,
): Parcelable