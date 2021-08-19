package com.sheyla.mymovies.presentation.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.mymovies.R
import com.sheyla.mymovies.databinding.ActivityProfilesBinding
import com.sheyla.mymovies.presentation.ListOfMovies

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