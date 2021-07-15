package com.sheyla.projeto_integrador.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sheyla.projeto_integrador.R

//lateinit var listMovies: TextView
//lateinit var movies: MutableList<Movie> = mutableListOf()

class MoviesFragment : Fragment() {
    @Override
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

       return inflater.inflate(R.layout.fragment_movies, container, false)
    }

}