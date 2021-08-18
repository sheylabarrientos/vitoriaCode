package com.sheyla.mymovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sheyla.mymovies.databinding.ActivityFormSubscribeBinding

class FormSubscribes : AppCompatActivity() {

    private lateinit var binding: ActivityFormSubscribeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormSubscribeBinding.inflate(layoutInflater)
            setContentView(binding.root)

        supportActionBar!!.hide()

        val toolbar = binding.toolbarSubscribe
        toolbar.setBackgroundColor(getColor(R.color.white))
        toolbar.setNavigationIcon(getDrawable(R.drawable.ic_netflix_official_logo))
    }
}