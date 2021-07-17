package com.sheyla.projeto_integrador.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.projeto_integrador.R
import com.sheyla.projeto_integrador.presentation.adapter.Adapter


class MoviesFragment : Fragment() {

    private lateinit var moviesAdapter: Adapter
//    lateinit var detailMovie: ImageButton
//    var detailListMovies: MutableList<Movie> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_movies, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moviesList: MutableList<Movie> = mutableListOf()
        val rvMovies = view.findViewById<RecyclerView>(R.id.list_movies)

        moviesAdapter = Adapter(context = view.context, dataset = moviesList)
        rvMovies.adapter = moviesAdapter
        rvMovies.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

//        detailMovie.setOnClickListener {
////            showDetailMovie()
//        }

    }

//    private fun showDetailMovie() {
//        val intent = Intent(this, DetailMovieActivity::class.java)
//        intent.putParcelableArrayList("MOVIES", detailListMovies)
//        startActivity(intent)
//    }

}