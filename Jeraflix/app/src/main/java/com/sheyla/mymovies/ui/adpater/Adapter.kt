package com.sheyla.mymovies.ui.adpater

import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.sheyla.mymovies.R
import com.sheyla.mymovies.domain.UserProfile

class Adapter(private val myDataSet: ArrayList<UserProfile>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: EditText = view.findViewById(R.id.name_profile)
        val textView: TextView = view.findViewById(R.id.item_name)
        val btnAdd: FloatingActionButton = view.findViewById(R.id.btn_add_profile)
        var watcher: TextWatcher? = null
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_add_profiles, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.removeTextChangedListener(holder.watcher)

        holder.name.setText(myDataSet[position].name)
        holder.watcher = holder.name.doAfterTextChanged { text ->
            if (!text.isNullOrBlank()) {
                myDataSet[position].name = text.toString()
            }
        }
        holder.textView.text = myDataSet[position].name

    }

    override fun getItemCount() = myDataSet.size

}