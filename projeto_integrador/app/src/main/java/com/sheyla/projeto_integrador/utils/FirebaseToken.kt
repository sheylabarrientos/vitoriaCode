package com.sheyla.projeto_integrador.utils

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.sheyla.projeto_integrador.R
import com.sheyla.projeto_integrador.presentation.HomeActivity

class FirebaseToken : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        Log.d("TokenFirebase", "Refreshed token: $token")
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
    }
}