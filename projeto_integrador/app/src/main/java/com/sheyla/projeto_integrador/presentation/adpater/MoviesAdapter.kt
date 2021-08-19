package com.sheyla.projeto_integrador.presentation.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.projeto_integrador.R
import com.bumptech.glide.Glide
import com.sheyla.projeto_integrador.data.Constants
import com.sheyla.projeto_integrador.domain.Movie
import com.sheyla.projeto_integrador.presentation.MovieListener

class MoviesRvAdapter(
    val context: Context,
    private val listener: MovieListener? = null,
    var dataSet: MutableList<Movie> = mutableListOf()
) : RecyclerView.Adapter<MoviesRvAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var imageMovie: ImageView? = view.findViewById(R.id.imageView5)
        var movieTitle: TextView? = view.findViewById(R.id.title_movie)
        var rating: TextView? = view.findViewById(R.id.percent_likes)
        var favBtn: ToggleButton? = view.findViewById(R.id.favorite_heart_empty)
        var movieId: TextView? = view.findViewById(R.id.movie_id)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.recycler_movies_list, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(dataSet[position].imgHome !== ""){
            holder.imageMovie?.let { Glide.with(context).load(Constants.BASE_URL_IMAGE.value + dataSet[position].imgHome).into(it) }
        }
        holder.movieTitle?.text = dataSet[position].title
        holder.rating?.text = dataSet[position].getRating()


        holder.imageMovie?.setOnClickListener {
            listener?.openMovieDetails(dataSet[position].id)
        }

        holder.favBtn?.isChecked = dataSet[position].isFavorite
        holder.favBtn?.setOnClickListener {
            listener?.onFavoriteClickedListener(dataSet[position], !dataSet[position].isFavorite)
        }

        holder.movieId?.text = dataSet[position].id.toString()
    }

    override fun getItemCount() = dataSet.size

}

