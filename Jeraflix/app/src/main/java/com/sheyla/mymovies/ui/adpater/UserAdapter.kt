package com.sheyla.mymovies.ui.adpater

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sheyla.mymovies.R
import com.sheyla.mymovies.ui.profile.UserProfile

class UserAdapter(val dataset: MutableList<UserProfile> = mutableListOf()) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_profile, viewGroup, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val username = view.findViewById<TextView>(R.id.item_name)
//        var btnRemoveProfile: Button? = view.findViewById(R.id.btnRemoveProfile)


//        override fun onClick(view: View?) {
////            val position = absoluteAdapterPosition
////            if (position != RecyclerView.NO_POSITION) {
////                listener.onItemClick(position, username)
////            }
//        }
    }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//       holder.imageProfile?.setOnClickListener {
//            listener?.openDetailProfile(dataset[position].name)
//        }
            holder.username?.text = dataset[position].name

//            holder.btnRemoveProfile?.setOnClickListener {
//                profileList.removeAt(position)
//                notifyItemRemoved(position)
//                notifyDataSetChanged()
//            }
        }

//
//        fun removeAt(index: Int) {
//            dataset.removeAt(index)
//            notifyDataSetChanged()
//        }

        override fun getItemCount(): Int = dataset.size

//    fun updateList(filteredList: MutableList<UserProfile>) {
//        dataset = filteredList
//        notifyDataSetChanged()
//    }
    }



