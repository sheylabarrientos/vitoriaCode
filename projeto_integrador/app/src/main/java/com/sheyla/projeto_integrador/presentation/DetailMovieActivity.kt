package com.sheyla.projeto_integrador.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.projeto_integrador.R
import kotlin.concurrent.fixedRateTimer


lateinit var btnBack: ImageButton
lateinit var imgMovie: ImageView
lateinit var favoriteHeartButton: ImageButton
lateinit var percentLikes: TextView
lateinit var titleMovie: TextView
lateinit var infosMovie: TextView
lateinit var categoriesOfMovie: TextView
lateinit var sinopse: TextView
lateinit var description: TextView
lateinit var infoElenco: TextView
lateinit var imageActor: RecyclerView


class DetailMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        bindViews()
//
//        val extras = intent.extras
//        val contatos = extras?.getParcelableArrayList<Movie>("MOVIES")
//        contatos?.let()
    }

private fun bindViews() {
    btnBack = findViewById(R.id.back_button)
    imgMovie = findViewById(R.id.cover_movie)
    favoriteHeartButton = findViewById(R.id.favorite_button_detail_movie)
    percentLikes = findViewById(R.id.percent_likes_detail_movies)
    titleMovie = findViewById(R.id.title_movie_detail_movie)
    infosMovie = findViewById(R.id.year_movie)
    categoriesOfMovie = findViewById(R.id.categories_details_movie)
    sinopse = findViewById(R.id.sinopse_detail_movie)
    description = findViewById(R.id.description_sinopse)
    infoElenco = findViewById(R.id.elenco_detail_movie)
    imageActor = findViewById(R.id.image_actor)

    }
}