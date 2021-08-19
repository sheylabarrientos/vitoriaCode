package com.sheyla.projeto_integrador.presentation.favorite

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.projeto_integrador.R
import com.sheyla.projeto_integrador.domain.Movie
import com.sheyla.projeto_integrador.presentation.MovieListener
import com.sheyla.projeto_integrador.presentation.model.MoviesViewModel
import com.sheyla.projeto_integrador.presentation.details.MovieDetailsActivity
import com.sheyla.projeto_integrador.presentation.adpater.GenresRvAdapter
import com.sheyla.projeto_integrador.presentation.adpater.MoviesRvAdapter
import com.sheyla.projeto_integrador.presentation.details.MovieDetailsActivity.Companion.MOVIE_ID

class FavoriteMoviesFragment : Fragment(), MovieListener {

    private lateinit var moviesAdapter: MoviesRvAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var genresAdapter: GenresRvAdapter
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

        genresAdapter = GenresRvAdapter(context = view.context, listener = this)
        moviesAdapter = MoviesRvAdapter(context = view.context, listener = this)
        rvGenres.adapter = genresAdapter
        rvMovies.adapter = moviesAdapter

        viewModelFavorites.getCategories()
        observeGenres()
        observeFavoriteMovies()

    }

    override fun onResume() {
        super.onResume()
        viewModelFavorites.getFavoriteMovies()
    }

    private fun observeGenres() {
        viewModelFavorites.genreListLiveData.observe(viewLifecycleOwner, { result ->
            result?.let {
                genresAdapter.dataset.addAll(it)
                genresAdapter.notifyDataSetChanged()
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

    override fun onFavoriteClickedListener(movie: Movie, isChecked: Boolean) {
        if (!isChecked) {
            movie.isFavorite = false
            viewModelFavorites.removeMovieFavorite(movie)
        }
    }

    override fun openMovieDetails(movieId: Int) {
        val intent = Intent(requireContext(), MovieDetailsActivity::class.java)
        intent.putExtra(MOVIE_ID, movieId)
        startActivity(intent)
    }

    override fun loadMoviesWithGenre(genreIds: List<Int>) {
        viewModelFavorites.favoriteMoviesLiveData.observe(viewLifecycleOwner, { result ->
            result?.let { movies ->
                val movieList = mutableListOf<Movie>()
                movies.forEach { movie ->
                    if (movie.genreIds.containsAll(genreIds)) {
                        movieList.add(movie)
                    }
                }
                moviesAdapter.dataSet.clear()
                moviesAdapter.dataSet.addAll(movieList)
                moviesAdapter.notifyDataSetChanged()
            }
        })
    }
}