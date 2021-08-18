package com.sheyla.mymovies.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.sheyla.mymovies.R
import com.sheyla.mymovies.presentation.model.MoviesViewModel

class ProgressActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MoviesViewModel.readDataBase()
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