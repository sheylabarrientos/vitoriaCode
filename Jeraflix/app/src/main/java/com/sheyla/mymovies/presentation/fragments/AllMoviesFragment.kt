package com.sheyla.mymovies.presentation.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.annotation.NonNull
import androidx.appcompat.widget.AppCompatToggleButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView
import com.sheyla.mymovies.R
import com.sheyla.mymovies.domain.Movie
import com.sheyla.mymovies.presentation.FailSystemActivity
import com.sheyla.mymovies.onclick.MovieListener
import com.sheyla.mymovies.presentation.adpater.CategoryAdapter
import com.sheyla.mymovies.presentation.adpater.MoviesAdapter
import com.sheyla.mymovies.presentation.infos.InfosMovieActivity
import com.sheyla.mymovies.presentation.infos.InfosMovieActivity.Companion.MOVIE_ID
import com.sheyla.mymovies.presentation.model.MoviesViewModel
import com.sheyla.mymovies.presentation.model.ViewState

class AllMoviesFragment : Fragment(), MovieListener {

    private lateinit var listAdapter: MoviesAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var moviesViewModel: MoviesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home_allmovies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvMovies = view.findViewById<RecyclerView>(R.id.rcvContainer)
        val rvGenres = view.findViewById<RecyclerView>(R.id.rcvAllMoviesTypes)


        categoryAdapter = CategoryAdapter(context = view.context, listener = this)
        listAdapter = MoviesAdapter(context = view.context, listener = this)
        rvMovies.adapter = listAdapter
        rvGenres.adapter = categoryAdapter

        moviesViewModel = ViewModelProvider(requireActivity()).get(MoviesViewModel::class.java)
        moviesViewModel.getPopularMovies()
        moviesViewModel.getGenres()
        progressBar = view.findViewById(R.id.loading)

        observeGenres()
        observeListMovies()
        observeViewState()

        rvMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(@NonNull recyclerView: RecyclerView, dx: Int, dy: Int): Unit {
                var layout =
                    (rvMovies.layoutManager as LinearLayoutManager).findViewByPosition((rvMovies.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition())

                val indexOfToggleButton = 2
                val indexOfId = 5

                if (layout is ConstraintLayout) {
                    if (layout.getChildAt(indexOfId) is MaterialTextView) {
                        val movieIdString =
                            (layout.getChildAt(indexOfId) as MaterialTextView).text.toString()
                        val movieId = Integer.parseInt(movieIdString)

                        (layout.getChildAt(indexOfToggleButton) as AppCompatToggleButton).isChecked =
                            MoviesViewModel.movieIdIsFavorite(movieId) == true
                    }
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        listAdapter.notifyDataSetChanged()
    }

    private fun observeListMovies() {
        moviesViewModel.movieListLiveData.observe(viewLifecycleOwner, { response ->
            response?.let {
                listAdapter.dataSet.clear()
                listAdapter.dataSet.addAll(it)
                listAdapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE
            }
        })
    }

    private fun observeGenres() {
        moviesViewModel.genreListLiveData.observe(viewLifecycleOwner, { response ->
            response?.let {
                categoryAdapter.dataset.addAll(it)
                categoryAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun observeViewState() {
        moviesViewModel.viewStateLiveData.observe(viewLifecycleOwner, { result ->
            if (result == ViewState.GeneralError) {
                val intent = Intent(requireContext(), FailSystemActivity::class.java)
                startActivity(intent)
            }
        })
    }

    override fun openMovieDetails(movieId: Int) {
        val intent = Intent(requireContext(), InfosMovieActivity::class.java)
        intent.putExtra(MOVIE_ID, movieId)
        startActivity(intent)
    }

    override fun loadMoviesWithGenre(genreIds: List<Int>) {
        moviesViewModel.getMoviesByGenre(genreIds)
    }

    override fun onFavoriteClickedListener(movie: Movie, isChecked: Boolean) {
        if (isChecked) {
            movie.isFavorite = true
            moviesViewModel.addToFavoriteMovie(movie)
            MoviesViewModel.writeFavoriteMovie(movie)
        } else {
            movie.isFavorite = false
            moviesViewModel.removeFavoriteMovie(movie)
            MoviesViewModel.deleteFavoriteMovie(movie)
        }
    }
}
