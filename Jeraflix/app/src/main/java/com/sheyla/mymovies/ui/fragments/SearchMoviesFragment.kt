package com.sheyla.mymovies.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.mymovies.R
import com.sheyla.mymovies.domain.Movie
import com.sheyla.mymovies.ui.FailSystemActivity
import com.sheyla.mymovies.onclick.MovieListener
import com.sheyla.mymovies.ui.adpater.CategoryAdapter
import com.sheyla.mymovies.ui.adpater.MoviesAdapter
import com.sheyla.mymovies.ui.infos.InfoMovieActivity
import com.sheyla.mymovies.ui.infos.InfoMovieActivity.Companion.MOVIE_ID
import com.sheyla.mymovies.ui.model.MoviesViewModel
import com.sheyla.mymovies.ui.model.ViewState

class SearchMoviesFragment : Fragment(), MovieListener {

    private var movieSearched: String? = null
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var movieNotFound: View
    private lateinit var rvMovies: RecyclerView
    private var moviesViewModel = MoviesViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieSearched = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_allmovies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvMovies = view.findViewById(R.id.rcvContainer)
        val rvGenres = view.findViewById<RecyclerView>(R.id.rcvAllMoviesTypes)

        movieNotFound = view.findViewById(R.id.movieNotFound)
        progressBar = view.findViewById(R.id.loading)
        progressBar.visibility = View.VISIBLE

        categoryAdapter = CategoryAdapter(context = view.context, listener = this)
        moviesAdapter = MoviesAdapter(context = view.context, listener = this)
        rvMovies.adapter = moviesAdapter
        rvGenres.adapter = categoryAdapter

        val movieUri = movieSearched?.toUri()
        if (movieUri != null) {
            updateQuery(movieUri)
        }
        observeMovies()
        progressBar.visibility = View.GONE

    }

    fun updateQuery(query: Uri) {
        observeGenres()
        setObservers()
        moviesViewModel.searchForMovie(query)
        moviesViewModel.getGenres()
        movieNotFound.visibility = View.GONE
    }

    private fun observeMovies() {
        moviesViewModel.searchResultsLiveData.observe(viewLifecycleOwner, { result ->
            result?.let {
                rvMovies.visibility = View.VISIBLE
                moviesAdapter.dataSet.clear()
                moviesAdapter.dataSet.addAll(it)
                moviesAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun observeGenres() {
        moviesViewModel.categoryListLiveData.observe(viewLifecycleOwner, { result ->
            result?.let {
                categoryAdapter.dataset.addAll(it)
                categoryAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun setObservers() {
        moviesViewModel.viewStateLiveData.observe(viewLifecycleOwner, { result ->
            when (result) {
                ViewState.MovieNotFound -> {
                    movieNotFound.visibility = View.VISIBLE
                    rvMovies.visibility = View.GONE
                }
                ViewState.GeneralError -> {
                    Toast.makeText(requireContext(), "General error", Toast.LENGTH_LONG).show()
                    val intent = Intent(requireContext(), FailSystemActivity::class.java)
                    startActivity(intent)
                }
            }
        })

    }

    override fun openMovieDetails(movieId: Int) {
        val intent = Intent(requireContext(), InfoMovieActivity::class.java)
        intent.putExtra(MOVIE_ID, movieId)
        startActivity(intent)
    }

    override fun loadMoviesWithGenre(genreIds: List<Int>) {
        moviesViewModel.searchResultsLiveData.observe(viewLifecycleOwner, { result ->
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

    override fun onWatchListClickedListener(movie: Movie, isChecked: Boolean) {
        if (isChecked) {
            movie.inWatchList = true
            moviesViewModel.addToFavoriteMovie(movie)
//            MoviesViewModel.writeFavoriteMovie(movie)
        } else {
            movie.inWatchList = false
            moviesViewModel.removeFavoriteMovie(movie)
//            MoviesViewModel.deleteFavoriteMovie(movie)
        }
    }

    override fun onWatchedListClickedListener(movie: Movie, isChecked: Boolean) {
        if (isChecked) {
            movie.watchedMovie = true
            moviesViewModel.addToWatchedList(movie)
            moviesViewModel.addToFavoriteMovie(movie)
        } else {
            movie.watchedMovie = false
            moviesViewModel.removeFavoriteMovie(movie)
        }
    }

    companion object {
        private const val ARG_PARAM1 = "movieSearched"

        @JvmStatic
        fun newInstance(movieSearched: String) =
            SearchMoviesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, movieSearched)
                }
            }
    }
}