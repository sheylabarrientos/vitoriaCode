package com.sheyla.mymovies.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.sheyla.mymovies.R
import com.sheyla.mymovies.databinding.ActivityProfilesBinding
import com.sheyla.mymovies.domain.Profiles
import com.sheyla.mymovies.ui.FailSystemActivity
import com.sheyla.mymovies.ui.adpater.UserAdapter
import com.sheyla.mymovies.domain.UserProfile
import com.sheyla.mymovies.ui.model.MoviesViewModel
import com.sheyla.mymovies.ui.model.ViewState
import kotlinx.android.synthetic.main.activity_profiles.*
import java.util.*
import kotlin.collections.ArrayList

class ProfilesActivity : AppCompatActivity() {

    private lateinit var profilesListRcv: RecyclerView
    private lateinit var addBtn: FloatingActionButton
    private lateinit var userAdapter: UserAdapter
    private lateinit var nameProfile: EditText
    private val viewModel = MoviesViewModel()
    private lateinit var binding: ActivityProfilesBinding

    var profiles = arrayListOf<UserProfile>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addBtn = findViewById(R.id.btn_add_profile_filho)
        nameProfile = findViewById(R.id.name_profile_filho)

        profilesListRcv = findViewById(R.id.recyclerViewProfiles)

        val extras = intent.extras
        val profiles = extras?.getParcelableArrayList<UserProfile>("PROFILES")
        profiles?.let { it1 -> showList(it1) }

        addBtn.setOnClickListener {
            SalvarDadosNoFirebase()
        }

        observeViewState()
    }


    private fun showList(profiles: ArrayList<UserProfile>) {
        userAdapter = UserAdapter(profiles)
        profilesListRcv.adapter = userAdapter
        profilesListRcv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        profilesListRcv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL)
    }


    private fun observeViewState(){
        viewModel.viewStateLiveData.observe(this, { result ->
            if(result == ViewState.GeneralError){
                val intent = Intent(this, FailSystemActivity::class.java)
                startActivity(intent)
            }
        })
    }

    private fun SalvarDadosNoFirebase() {

        val nomeUsuario = UUID.randomUUID().toString()
        FirebaseStorage.getInstance().getReference(
            "/profiles/${nomeUsuario}")

        val name = name_profile_filho.text.toString()
        val uid = FirebaseAuth.getInstance().uid

        val Profiles = Profiles(name)

        FirebaseFirestore.getInstance().collection("Profiles")
            .add(Profiles)
            .addOnSuccessListener {
                Toast.makeText(this, "Usuário cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this, "Tente novamente!", Toast.LENGTH_SHORT).show()
            }
    }

    companion object {
        const val USER_ID = "USER_ID"
        var profileList = mutableListOf<UserProfile>()
    }
}