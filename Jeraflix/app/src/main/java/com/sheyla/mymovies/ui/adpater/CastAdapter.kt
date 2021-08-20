package com.sheyla.mymovies.ui.adpater

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sheyla.mymovies.R
import com.sheyla.mymovies.data.base.Constants
import com.sheyla.mymovies.domain.Cast

class CastAdapter(val context: Context, var dataset: MutableList<Cast> = mutableListOf()) :
    RecyclerView.Adapter<CastAdapter.RecyclerviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewViewHolder =
        RecyclerviewViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_image_actor, parent, false)
        )

    class RecyclerviewViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var picture = view.findViewById<ImageView>(R.id.image_actor_detail_movie)
        var characterName = view.findViewById<TextView>(R.id.name_cast)
        var role = view.findViewById<TextView>(R.id.type_cast)
    }

    override fun onBindViewHolder(holder: RecyclerviewViewHolder, position: Int) {
        holder.picture?.let{ Glide.with(context).load(Constants.BASE_URL_IMAGE.value + dataset[position].profile_path).into(it) }
            holder.characterName.text = dataset[position].name
            holder.role.text = dataset[position].character
        }

    override fun getItemCount() = dataset.size

    }
