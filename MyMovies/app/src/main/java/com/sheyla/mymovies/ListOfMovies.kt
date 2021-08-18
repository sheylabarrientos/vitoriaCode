package com.sheyla.mymovies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.firebase.auth.FirebaseAuth
import com.sheyla.mymovies.databinding.ActivityLisfOfMoviesBinding

class ListOfMovies : AppCompatActivity() {

    private lateinit var binding: ActivityLisfOfMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLisfOfMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

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

    private fun backScreenLogin() {
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }
}