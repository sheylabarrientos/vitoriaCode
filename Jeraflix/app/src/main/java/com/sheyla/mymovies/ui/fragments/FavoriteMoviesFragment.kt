package com.sheyla.mymovies.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.mymovies.R
import com.sheyla.mymovies.domain.Movie
import com.sheyla.mymovies.onclick.MovieListener
import com.sheyla.mymovies.ui.adpater.CategoryAdapter
import com.sheyla.mymovies.ui.adpater.MoviesAdapter
import com.sheyla.mymovies.ui.infos.InfosMovieActivity
import com.sheyla.mymovies.ui.infos.InfosMovieActivity.Companion.MOVIE_ID
import com.sheyla.mymovies.ui.model.MoviesViewModel

class FavoriteMoviesFragment : Fragment(), MovieListener {

    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var rvGenres: RecyclerView
    private lateinit var rvMovies: RecyclerView
    private lateinit var viewModelFavorites: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_allmovies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvGenres = view.findViewById(R.id.rcvAllMoviesTypes)
        rvMovies = view.findViewById(R.id.rcvContainer)

        progressBar = view.findViewById(R.id.loading)

        viewModelFavorites = ViewModelProvider(requireActivity()).get(MoviesViewModel::class.java)

        categoryAdapter = CategoryAdapter(context = view.context, listener = this)
        moviesAdapter = MoviesAdapter(context = view.context, listener = this)
        rvGenres.adapter = categoryAdapter
        rvMovies.adapter = moviesAdapter

        viewModelFavorites.getGenres()
        observeGenres()
        observeFavoriteMovies()

    }

    override fun onResume() {
        super.onResume()
        viewModelFavorites.getFavoriteMovies()
    }

    private fun observeGenres() {
        viewModelFavorites.categoryListLiveData.observe(viewLifecycleOwner, { result ->
            result?.let {
                categoryAdapter.dataset.addAll(it)
                categoryAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun observeFavoriteMovies() {
        viewModelFavorites.favoriteMoviesLiveData.observe(viewLifecycleOwner, { result ->
            result?.let {
                moviesAdapter.dataSet.clear()
                moviesAdapter.dataSet.addAll(it)
                moviesAdapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE
            }
        })
    }

    override fun onWatchListClickedListener(movie: Movie, isChecked: Boolean) {
        if (!isChecked) {
            movie.inWatchList = false
            viewModelFavorites.removeFavoriteMovie(movie)
//            MoviesViewModel.deleteFavoriteMovie(movie)
        }
    }

    override fun openMovieDetails(movieId: Int) {
        val intent = Intent(requireContext(), InfosMovieActivity::class.java)
        intent.putExtra(MOVIE_ID, movieId)
        startActivity(intent)
    }

    override fun loadMoviesWithGenre(genreIds: List<Int>) {
        viewModelFavorites.favoriteMoviesLiveData.observe(viewLifecycleOwner, { result ->
            result?.let { movies ->
                val movieList = mutableListOf<Movie>()
                movies.forEach { movie ->
                    if (movie.categoryIds.containsAll(genreIds)) {
                        movieList.add(movie)
                    }
                }
                moviesAdapter.dataSet.clear()
                moviesAdapter.dataSet.addAll(movieList)
                moviesAdapter.notifyDataSetChanged()
            }
        })
    }

    override fun onWatchedListClickedListener(movie: Movie, isChecked: Boolean) {
        if (isChecked) {
            movie.watchedMovie = true
            viewModelFavorites.addToWatchedList(movie)
            viewModelFavorites.removeFavoriteMovie(movie)
//            MoviesViewModel.writeFavoriteMovie(movie)
        } else {
            movie.watchedMovie = false
            viewModelFavorites.deleteWatchedMovie(movie)
//            MoviesViewModel.deleteFavoriteMovie(movie)
        }
    }
}
