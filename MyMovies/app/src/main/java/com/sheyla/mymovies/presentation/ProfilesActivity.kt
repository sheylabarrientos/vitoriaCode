package com.sheyla.mymovies.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.mymovies.R
import com.sheyla.mymovies.databinding.ActivityAddProfilesBinding
import com.sheyla.mymovies.databinding.ActivityProfilesBinding

class ProfilesActivity : AppCompatActivity() {

//    private lateinit var imageProfile: Button
    private lateinit var profilesListRcv: RecyclerView
    private lateinit var adapter: ProfilesAdapter
    private lateinit var binding: ActivityProfilesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        profilesListRcv = findViewById(R.id.recyclerViewProfiles)

        val extras = intent.extras
        val profiles = extras?.getParcelableArrayList<UserProfile>("PROFILES")
        profiles?.let { it1 -> showList(it1) }

//        binding.btnAddProfile.setOnClickListener {
//            val intent = Intent(this, AddProfilesActivity::class.java)
//            startActivity(intent)
//            finish()
//        }

    }



    private fun showList(profiles: ArrayList<UserProfile>) {
        adapter = ProfilesAdapter(profiles)
        profilesListRcv.adapter = adapter
        profilesListRcv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun goToScreenMovie() {
        val intent = Intent(this, ListOfMovies::class.java)
        startActivity(intent)
        finish()
    }
}