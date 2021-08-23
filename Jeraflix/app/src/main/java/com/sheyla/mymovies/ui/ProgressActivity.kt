package com.sheyla.mymovies.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger
import com.sheyla.mymovies.R
import com.sheyla.mymovies.ui.login.FormLogin
import com.sheyla.mymovies.ui.model.MoviesViewModel

class ProgressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FacebookSdk.sdkInitialize(applicationContext)
        AppEventsLogger.activateApp(this)

//        MoviesViewModel.readDataBase()
        supportActionBar!!.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            openScreenLogin()
        },2000)
    }

    private fun openScreenLogin(){
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}