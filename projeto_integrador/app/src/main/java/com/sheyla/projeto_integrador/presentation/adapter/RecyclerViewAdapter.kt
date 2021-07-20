package com.sheyla.projeto_integrador.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.projeto_integrador.R
import com.sheyla.projeto_integrador.presentation.Details

class RecyclerViewAdapter (val context: Context, var dataSet: MutableList<Details> = mutableListOf()) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerviewViewHolder>() {

    class RecyclerviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        var imageMovie = view.findViewById<ImageButton>(R.id.imageView5)
        var movieTitle = view.findViewById<TextView>(R.id.title_movie)
        var rating = view.findViewById<TextView>(R.id.percent_likes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewViewHolder =
        RecyclerviewViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_movies, parent, false)
        )

    override fun onBindViewHolder(holder: RecyclerviewViewHolder, position: Int) {
//        if(dataSet[position].poster_path !== ""){
//           holder.imageMovie?.let { Glide.with(context).load("https://image.tmdb.org/t/p/w500" + dataSet[position].poster_path).into(it) }
//        }
        holder.movieTitle.text = dataSet[position].title
        holder.rating.text = dataSet[position].vote_average.toString()
    }


override fun getItemCount() = dataSet.size

}