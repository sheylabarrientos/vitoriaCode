package com.sheyla.mymovies.presentation.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.mymovies.R
import com.sheyla.mymovies.databinding.ActivityProfilesBinding
import com.sheyla.mymovies.presentation.Add
import com.sheyla.mymovies.presentation.ListOfMovies
import kotlinx.android.synthetic.main.activity_add_profiles.*
import kotlinx.android.synthetic.main.activity_profiles.*
import kotlinx.android.synthetic.main.item_profile.*

class ProfilesActivity : AppCompatActivity() {

    private lateinit var profilesListRcv: RecyclerView
    private lateinit var adapter: ProfilesAdapter
    private lateinit var binding: ActivityProfilesBinding
    private val remove = Add()
    var user = arrayListOf<UserProfile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        profilesListRcv = findViewById(R.id.recyclerViewProfiles)


        val extras = intent.extras
        val profiles = extras?.getParcelableArrayList<UserProfile>("PROFILES")
        profiles?.let { it1 -> showList(it1) }


        binding.btnRemoveProfile.setOnClickListener {
            removeProfile()
        }

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

    private fun removeProfile(){
        val remove = remove.unsubscribeProfile()

        if(remove != -1){
            Toast.makeText(this, "Não existem usuários cadastrados", Toast.LENGTH_SHORT).show()
        }else{
            val profile = recyclerViewProfiles.getChildAdapterPosition(name_profile)
            user.remove(UserProfile(profile.toString()))
            Toast.makeText(this, "Perfil removido com sucesso!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToScreenMovie() {
        val intent = Intent(this, ListOfMovies::class.java)
        startActivity(intent)
        finish()
    }
}