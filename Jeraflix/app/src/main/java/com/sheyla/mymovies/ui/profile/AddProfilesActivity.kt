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
import com.sheyla.mymovies.domain.Add
import com.sheyla.mymovies.ui.login.FormLogin
import com.sheyla.mymovies.domain.UserProfile

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
            val messageError: String = name.text.toString()
            if (messageError.trim().isEmpty()) {
                name.error = "Digite um nome"
            }else{
                irParaProfileActivity()
//                finish()
            }
        }
    }

    private fun irParaProfileActivity() {
        addProfile() //função salvar contato
        val intent = Intent(this, ProfilesActivity::class.java)
        intent.putParcelableArrayListExtra("PROFILES", profiles)
        startActivity(intent)
        finish()
    }


    private fun addProfile(): List<UserProfile> {
        val add = add.subscribeProfile()
        //check if the EditText have values or not
        if (add != -1) {
            val nomeDigitado = name.text.toString()
            profiles.add(UserProfile(nomeDigitado))
            Toast.makeText(
                applicationContext,
                "Perfil criado com sucesso!",
                Toast.LENGTH_SHORT
            ).show()
        }
        else{
            Toast.makeText(
                applicationContext,
                "Você criou o número máximo de perfis.",
                Toast.LENGTH_SHORT
            ).show()
        }
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
