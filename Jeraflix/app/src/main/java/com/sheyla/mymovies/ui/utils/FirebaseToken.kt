package com.sheyla.mymovies.ui.utils

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class FirebaseToken: FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        Log.d("TokenFirebase", "Refreshed token: $token")

    }

    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
    }
}