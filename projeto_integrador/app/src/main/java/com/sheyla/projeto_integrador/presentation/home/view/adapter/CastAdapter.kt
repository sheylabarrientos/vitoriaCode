package com.sheyla.projeto_integrador.presentation.home.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sheyla.projeto_integrador.R
import com.sheyla.projeto_integrador.data.modelresponse.InfosCast

class CastAdapter(val context: Context, var dataSetCast: MutableList<InfosCast> = mutableListOf()) : RecyclerView.Adapter<CastAdapter.RecyclerviewViewHolder>() {

    class RecyclerviewViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var picture = view.findViewById<ImageView>(R.id.image_actor_detail_movie)
        var characterName = view.findViewById<TextView>(R.id.name_cast)
        var role = view.findViewById<TextView>(R.id.type_cast)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerviewViewHolder = RecyclerviewViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_image_actor, parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerviewViewHolder, position: Int) {
        if(dataSetCast[position].profile_path !== ""){
            holder.picture?.let { Glide.with(context).load("https://image.tmdb.org/t/p/w500" + dataSetCast[position].profile_path).into(it) }
        }
        holder.characterName.text = dataSetCast[position].name
        holder.role.text = dataSetCast[position].character
    }

    override fun getItemCount() = dataSetCast.size

}