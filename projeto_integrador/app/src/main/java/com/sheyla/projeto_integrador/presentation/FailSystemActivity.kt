package com.sheyla.projeto_integrador.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.sheyla.projeto_integrador.R

lateinit var tryAgain: TextView

class FailSystemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fail_system)

        tryAgain = findViewById(R.id.try_again_fail_system)

        tryAgain.setOnClickListener(){
            onStart()
        }
    }

    override fun onStart() {
        super.onStart()
    }
}