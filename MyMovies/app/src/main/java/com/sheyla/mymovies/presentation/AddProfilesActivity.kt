package com.sheyla.mymovies.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.HttpMethod
import com.facebook.login.LoginManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.sheyla.mymovies.R
import com.sheyla.mymovies.databinding.ActivityAddProfilesBinding

class AddProfilesActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var button: FloatingActionButton

    private lateinit var binding: ActivityAddProfilesBinding

    var user = arrayListOf<UserProfile>() //lista de contatos declaração
    lateinit var usersSubscribes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProfilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindViews()

        binding.btnAddProfile.setOnClickListener {
            goToProfiles()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.disconnect -> {
                FirebaseAuth.getInstance().signOut()
                backScreenLogin()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun goToProfiles() {
        addProfile() //função salvar perfil
        val intent = Intent(this, ProfilesActivity::class.java)
        intent.putParcelableArrayListExtra("PROFILES", user)
        startActivity(intent)
    }

    private fun addProfile(): List<UserProfile> {

        if (name.text.isEmpty()) {
            name.error = "Digite um nome."
        } else {
            val nomeDigitado = name.text.toString()
            user.add(UserProfile(nomeDigitado))
        }
        return user
    }

    private fun bindViews() {
        name = findViewById(R.id.name_profile)
    }

    private fun backScreenLogin() {
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()

        if (AccessToken.getCurrentAccessToken() != null) {
            GraphRequest(AccessToken.getCurrentAccessToken(), "/me/permissions/", null, HttpMethod.DELETE, GraphRequest.Callback {
                AccessToken.setCurrentAccessToken(null)
                LoginManager.getInstance().logOut()

                finish()
            }).executeAsync()
        }
    }
}
