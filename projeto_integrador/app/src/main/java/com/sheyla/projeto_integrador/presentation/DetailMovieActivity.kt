package com.sheyla.projeto_integrador.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.projeto_integrador.R
import com.sheyla.projeto_integrador.presentation.home.view.adapter.CastAdapter

private val viewModel = DetailsViewModel()

lateinit var castAdapter: CastAdapter
lateinit var containerCast: RecyclerView

lateinit var btnBack: ImageButton
lateinit var imgMovie: ImageView
lateinit var favoriteHeartButton: ImageButton
lateinit var percentLikes: TextView
lateinit var titleMovie: TextView
lateinit var infosMovie: TextView
lateinit var categoriesOfMovie: TextView
lateinit var sinopse: TextView
lateinit var description: TextView
lateinit var infoElenco: TextView
lateinit var imageActor: RecyclerView


class DetailMovieActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        bindViews()
//
//        val extras = intent.extras
//        val contatos = extras?.getParcelableArrayList<Movie>("MOVIES")
//        contatos?.let()

//        val movieId: Int = intent.getIntExtra("id", 1)
//
//        val apiService: TheMovieDBInterface = TheMovieDBClient.getClient()
//        movieRepository = MovieDetailsRepository(apiService)
//
//        viewModel = getViewModel(movieId)
//        viewModel.movieDetails.observe(this, Observer {
//            bindUI(it)
//        })

        //Chamada da Recyclerview do CastAdapter.
        containerCast = findViewById(R.id.image_actor)
        castAdapter = CastAdapter(context = this)
        containerCast.adapter = castAdapter
        containerCast.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

private fun bindViews() {
    btnBack = findViewById(R.id.back_button)
    imgMovie = findViewById(R.id.cover_movie)
    favoriteHeartButton = findViewById(R.id.favorite_button_detail_movie)
    percentLikes = findViewById(R.id.percent_likes_detail_movies)
    titleMovie = findViewById(R.id.title_movie_detail_movie)
    infosMovie = findViewById(R.id.year_movie)
    categoriesOfMovie = findViewById(R.id.categories_details_movie)
    sinopse = findViewById(R.id.sinopse_detail_movie)
    description = findViewById(R.id.description_sinopse)
    infoElenco = findViewById(R.id.elenco_detail_movie)
    imageActor = findViewById(R.id.image_actor)

    }

//    fun bindUI( it: MovieDetails){
//
//        movieTitle.text = it.title
//        movieYear.text = it.release_date
//        ageRestriction.text = it.adult.toString()
//        movieDuration.text = it.runtime.toString() + " minutes"
//        movieSynopsis.text = it.overview
//        ratingMovieInfoAct.text = it.popularity.toString()
//
//        val moviePosterURL: String = POSTER_BASE_URL + it.poster_path
//        Glide.with(this)
//            .load(moviePosterURL)
//            .into(posterMovie);
//
//    }
//
//    private fun getViewModel(movieId:Int): SingleMovieViewModel {
//        return ViewModelProvider(this, object: ViewModelProvider.Factory {
//            override fun<T : ViewModel?> create(modelClass: Class<T>): T {
//                return SingleMovieViewModel(movieRepository,movieId) as T
//            }
//        })[SingleMovieViewModel::class.java]
//    }
}