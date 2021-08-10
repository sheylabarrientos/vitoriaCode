package com.sheyla.projeto_integrador.presentation

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.projeto_integrador.R
import com.sheyla.projeto_integrador.domain.DatabaseHandler
import com.sheyla.projeto_integrador.domain.Movie
import com.sheyla.projeto_integrador.presentation.home.view.adapter.GenresRvAdapter
import com.sheyla.projeto_integrador.presentation.home.view.adapter.MoviesRvAdapter
import com.sheyla.projeto_integrador.presentation.model.ViewState

class AllMoviesFragment : Fragment(), MovieListener {

    private lateinit var listAdapter: MoviesRvAdapter
    private lateinit var genresAdapter: GenresRvAdapter
    private lateinit var progressBar: ProgressBar
    private lateinit var moviesViewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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

        genresAdapter = GenresRvAdapter(context = view.context, listener = this)
        listAdapter = MoviesRvAdapter(context = view.context, listener = this)
        rvMovies.adapter = listAdapter
        rvGenres.adapter = genresAdapter

        moviesViewModel = ViewModelProvider(requireActivity()).get(MoviesViewModel::class.java)
        moviesViewModel.getPopularMovies()
        moviesViewModel.getGenres()
        progressBar = view.findViewById(R.id.loading)

        setupGenresObserveList()
        setupObserveList()
        observeViewState()

        //val rvMovies = view.findViewById<RecyclerView>(R.id.rcvContainer)


        val timer = object : CountDownTimer(5000, 1000) {

            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {

                var i = 0
                var j = 0
                var k = 0
                var indexOfToggleButton: Int = 0
                var movieTitle: String = ""
                var counter = 0


                println("Temos " + rvMovies.childCount + " childs")

                while (i < rvMovies.childCount) {
                    while (j < (rvMovies.getChildAt(i) as ConstraintLayout).childCount) {
                        if ((rvMovies.getChildAt(i) as ConstraintLayout).getChildAt(j) is TextView) {
                            //procurar o toggle button, comparar os textos e setar o toggle button
                            println("counter " + counter)
                            counter++
                        }

                        j++
                    }
                    i++
                }

                this.start()

            }
        }.start()


    }

    override fun onResume() {
        super.onResume()
        listAdapter.notifyDataSetChanged()
    }


    //Aqui se está dizendo "observe a viewmodel e quando algo acontecer a ela, a atrele ao adapter.
    private fun setupObserveList() {
        moviesViewModel.movieListLiveData.observe(viewLifecycleOwner, { response ->
            response?.let {
                listAdapter.dataSet.clear()
                listAdapter.dataSet.addAll(it)
                listAdapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE
            }
        })
    }

    //Aqui se está dizendo "observe a viewmodel e quando algo acontecer a ela a atrele ao adapter".
    private fun setupGenresObserveList() {
        moviesViewModel.genreListLiveData.observe(viewLifecycleOwner, { response ->
            response?.let {
                genresAdapter.dataset.addAll(it)
                genresAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun observeViewState(){
        moviesViewModel.viewStateLiveData.observe(viewLifecycleOwner, { result ->
            when(result){
                ViewState.GeneralError -> {
                    Toast.makeText(requireContext(), "General error all movies fragment", Toast.LENGTH_LONG).show()
                    val intent = Intent(requireContext(), FailSystemActivity::class.java)
                    startActivity(intent)
                }
            }
        })
    }

    override fun openMovieDetails(movieId: Int) {
        val intent = Intent(requireContext(), MovieDetailsActivity::class.java)
        intent.putExtra("MOVIE_ID", movieId)
        startActivity(intent)
    }

    override fun loadMoviesWithGenre(genreIds: List<Int>) {
        moviesViewModel.getMoviesByGenre(genreIds)
        println("Carregou")


    }


    override fun onFavoriteClickedListener(movie: Movie, isChecked: Boolean) {
        if (isChecked) {
            movie.isFavorite = true
            moviesViewModel.favoriteMovie(movie)
            DatabaseHandler.writeFavoriteMovie(movie)
        } else {
            movie.isFavorite = false
            moviesViewModel.unfavoriteMovie(movie)
            DatabaseHandler.deleteFavoriteMovie(movie)
        }
    }
}
