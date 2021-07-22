package com.sheyla.projeto_integrador.presentation.home.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sheyla.projeto_integrador.R
import com.sheyla.projeto_integrador.data.modelresponse.Movie

//const val API_KEY = "9785973f3bb15c2a21794223b39bfcb8"
//const val BASE_URL = "https://api.themoviedb.org/3/"
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/w342"
const val FAVORITES_PATH = "/favorites"

class Adapter(var dataset: MutableList<Movie> = mutableListOf()) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageMovie = view.findViewById<ImageView>(R.id.imageView5)
        val title = view.findViewById<TextView>(R.id.title_movie)
        val favorite = view.findViewById<ImageButton>(R.id.favorite_heart_empty)

        val percentLikes = view.findViewById<TextView>(R.id.percent_likes)

        fun bindMovie(movie: Movie){
            Glide.with(imageMovie.context).load("$POSTER_BASE_URL${movie.poster_path}")
                .placeholder(R.mipmap.ic_launcher)
                .into(imageMovie)

            title.text = movie.title
            percentLikes.text = movie.popularity.toString()
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.recycler_movies_list, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindMovie(dataset[position])
    }

    override fun getItemCount() = dataset.size

    fun updateList(newList : MutableList<Movie>){
        this.dataset.removeAll(dataset)
        this.dataset = newList
        notifyDataSetChanged()
    }
}


