package com.sheyla.mymovies.ui.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.sheyla.mymovies.R
import com.sheyla.mymovies.domain.Category
import com.sheyla.mymovies.onclick.MovieListener

class CategoryAdapter(
    val context: Context,
    private val listener: MovieListener? = null,
    var dataset: MutableList<Category> = mutableListOf()
): RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private val selectedItems: MutableList<Int> = mutableListOf()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val genreChip: Chip? = view.findViewById(R.id.itemGenre)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_all_genres, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.genreChip?.text = dataset[position].name
        holder.genreChip?.setOnClickListener {
            if (selectedItems.contains(dataset[position].id)) {
                selectedItems.remove(dataset[position].id)
            } else {
                selectedItems.add(dataset[position].id)
            }
            listener?.loadMoviesWithGenre(selectedItems)
        }
    }

    override fun getItemCount() = dataset.size
}