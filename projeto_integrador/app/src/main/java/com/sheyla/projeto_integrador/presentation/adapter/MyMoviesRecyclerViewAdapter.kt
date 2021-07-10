package com.sheyla.projeto_integrador.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView

import com.sheyla.projeto_integrador.placeholder.PlaceholderContent.PlaceholderItem
import com.sheyla.projeto_integrador.databinding.FragmentMoviesBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyMoviesRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<MyMoviesRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentMoviesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.idView.text = item.id
        holder.contentView.text = item.content
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentMoviesBinding) : RecyclerView.ViewHolder(binding.root) {
        val idView: TextView = binding.titleMovie
        val contentView: TextView = binding.percentLikes

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }

}