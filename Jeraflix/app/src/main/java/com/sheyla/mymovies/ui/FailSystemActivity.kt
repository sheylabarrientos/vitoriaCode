package com.sheyla.mymovies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.sheyla.mymovies.R

class FailSystemActivity : AppCompatActivity() {

    private lateinit var closeButton: ImageButton
    private lateinit var tryAgain: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fail_system)

        closeButton = findViewById(R.id.close_button)
        tryAgain = findViewById(R.id.try_again_fail_system)

        closeButton.setOnClickListener { finish() }
        tryAgain.setOnClickListener { finish() }
    }
}
