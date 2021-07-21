package com.sheyla.projeto_integrador.presentation.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.projeto_integrador.R
import com.sheyla.projeto_integrador.data.modelresponse.Movie
import com.sheyla.projeto_integrador.presentation.home.view.adapter.Adapter
import com.sheyla.projeto_integrador.presentation.home.view.adapter.RecyclerViewAdapter
import com.sheyla.projeto_integrador.presentation.home.viewmodel.HomeViewModel


class MoviesFragment : Fragment() {

    private val moviesAdapter: Adapter by lazy {
        Adapter(mutableListOf())
    }

    private lateinit var listAdapter: RecyclerViewAdapter
    lateinit var recyclerMovies: RecyclerView

    private val viewModel : HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerMovies = view.findViewById(R.id.list_movies)
        recyclerMovies.adapter = moviesAdapter
        recyclerMovies.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        viewModel.getMovies()

        initObservables()

//        detailMovie.setOnClickListener {
////            showDetailMovie()
//        }

    }

    private fun initObservables(){
        viewModel.moviesListResult.observe(viewLifecycleOwner, Observer { movies ->
            moviesAdapter.updateList(movies as MutableList<Movie>)
        })
    }

//    private fun showDetailMovie() {
//        val intent = Intent(this, DetailMovieActivity::class.java)
//        intent.putParcelableArrayList("MOVIES", detailListMovies)
//        startActivity(intent)
//    }

}