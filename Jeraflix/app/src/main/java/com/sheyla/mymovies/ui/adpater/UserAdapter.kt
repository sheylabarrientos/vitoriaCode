package com.sheyla.mymovies.ui.adpater

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.mymovies.R
import com.sheyla.mymovies.ui.ListOfMoviesActivity
import com.sheyla.mymovies.domain.UserProfile

class UserAdapter(var dataset: MutableList<UserProfile> = mutableListOf()) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_profile, viewGroup, false)
    )

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val username = view.findViewById<TextView>(R.id.item_name)
        var imageProfile = view.findViewById<TextView>(R.id.imageProfile)
        var btnRemoveProfile: Button? = view.findViewById(R.id.btnRemoveProfile)


    }


    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
//       holder.imageProfile?.setOnClickListener {
//            listener?.openDetailProfile(dataset[position].name)
//        }

        holder.username?.text = dataset[position].name

        holder.imageProfile?.setOnClickListener {
            val intent = Intent(it.context, ListOfMoviesActivity::class.java)
            intent.putExtra("profiles", dataset.get(position))
            it.context.startActivity(intent)
        }

//            holder.btnRemoveProfile?.setOnClickListener {
//                dataset.removeAt(position)
//                notifyItemRemoved(position)
//            }

        holder.btnRemoveProfile?.setOnClickListener { deleteItem(position) }
    }

    private fun deleteItem(position: Int) {
        dataset.removeAt(position)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = dataset.size

    fun updateList() {
        notifyDataSetChanged()
    }

}



