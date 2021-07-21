package com.sheyla.projeto_integrador.presentation.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.projeto_integrador.R
import com.sheyla.projeto_integrador.data.model.Movies

class Adapter(val context: Context, var dataset: MutableList<Movies> = mutableListOf()) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome = view.findViewById<TextView>(R.id.title_movie)
        val likes = view.findViewById<TextView>(R.id.percent_likes)

//        fun bindMovie(movie: Movie){
//            titleMovie.text = movie.nome
//            percentLikes.text = movie.likes
//        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.fragment_movies, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.nome.text = dataset[position].list
//        holder.likes.text = dataset[position].list
    }

    override fun getItemCount() = dataset.size
}


