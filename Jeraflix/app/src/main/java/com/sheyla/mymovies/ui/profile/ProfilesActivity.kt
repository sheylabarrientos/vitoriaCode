package com.sheyla.mymovies.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sheyla.mymovies.R
import com.sheyla.mymovies.databinding.ActivityProfilesBinding
import com.sheyla.mymovies.ui.Add
import com.sheyla.mymovies.ui.FailSystemActivity
import com.sheyla.mymovies.ui.adpater.UserAdapter
import com.sheyla.mymovies.ui.model.MoviesViewModel
import com.sheyla.mymovies.ui.model.ViewState

class ProfilesActivity : AppCompatActivity() {

    private lateinit var profilesListRcv: RecyclerView
    private lateinit var backBtn: FloatingActionButton
    private lateinit var btnRemoveProfile: Button
    private lateinit var userAdapter: UserAdapter
    private val viewModel = MoviesViewModel()
    private lateinit var binding: ActivityProfilesBinding
    private val remove = Add()

    var profiles = arrayListOf<UserProfile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backBtn = findViewById(R.id.returnBtn)
//        nome = findViewById(R.id.item_name)
//        btnRemoveProfile = findViewById(R.id.btnRemoveProfile)

        profilesListRcv = findViewById(R.id.recyclerViewProfiles)

        val extras = intent.extras
        val profiles = extras?.getParcelableArrayList<UserProfile>("PROFILES")
        profiles?.let { it1 -> showList(it1) }

//        btnRemoveProfile.setOnClickListener {
//            removeProfile()
//        }

        backBtn.setOnClickListener { finish() }

    }

//    fun openMovieDetails(movieId: Int) {
////        val intent = Intent(requireContext(), ListOfMovies::class.java)
////        intent.putExtra(InfosMovieActivity.MOVIE_ID, movieId)
////        startActivity(intent)
//    }

    private fun showList(profiles: ArrayList<UserProfile>) {
        userAdapter = UserAdapter(profiles)
        profilesListRcv.adapter = userAdapter
        profilesListRcv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }


    private fun observeViewState(){
        viewModel.viewStateLiveData.observe(this, { result ->
            if(result == ViewState.GeneralError){
                val intent = Intent(this, FailSystemActivity::class.java)
                startActivity(intent)
            }
        })
    }

//    private fun removeProfile(){
//        val remove = remove.unsubscribeProfile()
//
//        if(remove != -1){
//            Toast.makeText(this, "Não existem usuários cadastrados", Toast.LENGTH_SHORT).show()
//        }else{
//            //NÃO FUNCIONA =(
//            val profile = recyclerViewProfiles.getChildAdapterPosition(name_profile)
//            profiles.remove(UserProfile(profile.toString()))
//            Toast.makeText(this, "Perfil removido com sucesso!", Toast.LENGTH_SHORT).show()
//        }
//    }

    companion object {
        const val USER_ID = "USER_ID"
        var profileList = mutableListOf<UserProfile>()
    }
}