package com.sheyla.mymovies.ui.profile


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.HttpMethod
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth
import com.sheyla.mymovies.R
import com.sheyla.mymovies.databinding.ActivityAddProfilesBinding
import com.sheyla.mymovies.ui.Add
import com.sheyla.mymovies.ui.ListOfMovies
import com.sheyla.mymovies.ui.login.FormLogin

class AddProfilesActivity : AppCompatActivity() {

    private lateinit var name: EditText

    private lateinit var binding: ActivityAddProfilesBinding
    private val add = Add()
//    var user = arrayListOf<UserProfile>() //lista de perfis
    var profiles = arrayListOf<UserProfile>()

    lateinit var usersSubscribes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProfilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindViews()

        binding.btnAddProfile.setOnClickListener {
            irParaProfileActivity()
        }
    }

    private fun irParaProfileActivity() {
        salvarContato() //função salvar contato
        val intent = Intent(this, ProfilesActivity::class.java)
        intent.putParcelableArrayListExtra("PROFILES", profiles)
        startActivity(intent)
    }

    private fun salvarContato(): List<UserProfile> {
        val messageError: String = name.text.toString()
        val add = add.subscribeProfile()
        //check if the EditText have values or not
        if (add != -1) {
            if (messageError.trim().isEmpty()) {
                name.error = "Digite um nome"
            } else {
                val nomeDigitado = name.text.toString()
                Toast.makeText(
                    applicationContext,
                    "Perfil criado com sucesso!",
                    Toast.LENGTH_SHORT
                ).show()

                // After successful login u will move on next page/ activity
                profiles.add(UserProfile(nomeDigitado))
            }}
            return profiles
        }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.disconnect -> {
                FirebaseAuth.getInstance().signOut()
                backScreenLogin()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun bindViews() {
        name = findViewById(R.id.name_profile)
    }

    private fun backScreenLogin() {
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()

        if (AccessToken.getCurrentAccessToken() != null) {
            GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/permissions/",
                null,
                HttpMethod.DELETE,
                GraphRequest.Callback {
                    AccessToken.setCurrentAccessToken(null)
                    LoginManager.getInstance().logOut()

                    finish()
                }).executeAsync()
        }
    }
}
