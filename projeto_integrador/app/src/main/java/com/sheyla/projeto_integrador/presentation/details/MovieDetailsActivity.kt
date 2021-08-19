package com.sheyla.projeto_integrador.presentation.details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.imageview.ShapeableImageView
import com.sheyla.projeto_integrador.R
import com.sheyla.projeto_integrador.data.base.Constants
import com.sheyla.projeto_integrador.domain.MovieDetail
import com.sheyla.projeto_integrador.presentation.FailSystemActivity
import com.sheyla.projeto_integrador.presentation.adpater.CastRvAdapter
import com.sheyla.projeto_integrador.presentation.adpater.MovieDetailsGenresRvAdapter
import com.sheyla.projeto_integrador.presentation.model.ViewState
import kotlinx.android.synthetic.main.activity_detail_movie.*

class MovieDetailsActivity : AppCompatActivity() {

    private val viewModel = MovieDetailsViewModel()
    private lateinit var movieLength: TextView
    private lateinit var infoPage: TextView
    private lateinit var genresRv: RecyclerView
    private lateinit var castRv: RecyclerView
    lateinit var castRvAdapter: CastRvAdapter
    lateinit var genresAdapter: MovieDetailsGenresRvAdapter
    lateinit var btnBack: FloatingActionButton
    lateinit var imgMovie: ShapeableImageView
    lateinit var favoriteHeartButton: ImageView
    lateinit var percentLikes: TextView
    lateinit var titleMovie: TextView
    lateinit var yearMovie: TextView
    lateinit var sinopse: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        bindViews()

        val movieId = intent.extras?.getInt(MOVIE_ID)

        viewModel.getMovieDetails(movieId!!)
        getMovieDetails()
        observeViewState()

        btnBack.setOnClickListener { finish() }

    }

    private fun bindViews() {
        btnBack = findViewById(R.id.back_button)
        imgMovie = findViewById(R.id.cover_movie)
        favoriteHeartButton = findViewById(R.id.favorite_button_detail_movie)
        percentLikes = findViewById(R.id.percent_likes_detail_movies)
        titleMovie = findViewById(R.id.title_movie_detail_movie)
        yearMovie = findViewById(R.id.year_movie)
        movieLength = findViewById(R.id.txtMovieLength)
        infoPage = findViewById(R.id.txtPage)
        sinopse = findViewById(R.id.description_sinopse)
        genresRv = findViewById(R.id.rcvMovieGenres)
        castRv = findViewById(R.id.image_actor)

    }

    private fun observeViewState(){
        viewModel.viewStateLiveData.observe(this, { result ->
            if(result == ViewState.GeneralError){
                val intent = Intent(this, FailSystemActivity::class.java)
                startActivity(intent)
            }
        })
    }

    private fun getMovieDetails() {
        viewModel.movieLiveData.observe(this, { response ->
            response?.let {
                showMovie(it)
            }
        })
    }

    private fun showMovie(movie: MovieDetail) {
        genresAdapter = MovieDetailsGenresRvAdapter(movie.genres)
        genresRv.adapter = genresAdapter

        castRvAdapter = CastRvAdapter(this)
        image_actor.adapter = castRvAdapter

        viewModel.getCast(movie.id)
        observeCastOfMovie()

        movie.backdrop_path?.let {
            Glide.with(this).load(Constants.BASE_URL_IMAGE.value + movie.backdrop_path)
                .into(imgMovie)
        }
        movie.overview?.let {
            sinopse.text = it
        }
        movie.runtime?.let {
            movieLength.text = movie.getRuntime()
        }

        titleMovie.text = movie.title
        percentLikes.text = movie.getRating()

        if (movie.isFavorite) {
            favoriteHeartButton.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            favoriteHeartButton.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
        yearMovie.text = movie.getReleaseYear()

        viewModel.getCertification(movie.id)
        observeCertification()
    }

    private fun observeCertification() {
        viewModel.certificationLiveData.observe(this, { result ->
            result?.let {
                it.forEach { parental_guidance ->
                    infoPage.text = ("PG-" + parental_guidance.certification)
                }
            }
        })
    }

    private fun observeCastOfMovie() {
        viewModel.castLiveData.observe(this, { result ->
            result?.let {
                castRvAdapter.dataset.addAll(it)
                castRvAdapter.notifyDataSetChanged()
            }
        })
    }

    companion object {
        const val MOVIE_ID = "MOVIE_ID"
    }
}