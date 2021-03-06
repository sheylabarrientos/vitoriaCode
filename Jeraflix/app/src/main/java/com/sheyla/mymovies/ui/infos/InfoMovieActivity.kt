package com.sheyla.mymovies.ui.infos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.imageview.ShapeableImageView
import com.sheyla.mymovies.R
import com.sheyla.mymovies.data.base.Constants
import com.sheyla.mymovies.domain.MovieDetail
import com.sheyla.mymovies.ui.FailSystemActivity
import com.sheyla.mymovies.ui.adpater.CastAdapter
import com.sheyla.mymovies.ui.adpater.InfosMoviesCategoryAdapter
import com.sheyla.mymovies.ui.model.ViewState
import kotlinx.android.synthetic.main.activity_detail_movie.*

class InfoMovieActivity : AppCompatActivity() {

    private val viewModel = InfoMoviesViewModel()
    private lateinit var movieLength: TextView
    private lateinit var infoPage: TextView
    private lateinit var genresRv: RecyclerView
    private lateinit var castRv: RecyclerView
    lateinit var castAdapter: CastAdapter
    lateinit var genresAdapter: InfosMoviesCategoryAdapter
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
        genresAdapter = InfosMoviesCategoryAdapter(movie.categories)
        genresRv.adapter = genresAdapter

        castAdapter = CastAdapter(this)
        image_actor.adapter = castAdapter

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
                castAdapter.dataset.addAll(it)
                castAdapter.notifyDataSetChanged()
            }
        })
    }

    companion object {
        const val MOVIE_ID = "MOVIE_ID"
    }
}