package com.sheyla.mymovies.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.FirebaseFirestore
import com.sheyla.mymovies.R
import com.sheyla.mymovies.domain.Profiles
import com.sheyla.mymovies.ui.ListOfMoviesActivity
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_profiles.*
import kotlinx.android.synthetic.main.item_profile_filho.*
import kotlinx.android.synthetic.main.item_profile_filho.view.*

class FragmentProfiles : Fragment() {

    private lateinit var Adapter: GroupAdapter<ViewHolder>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profiles, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Adapter = GroupAdapter()
        rcvProfiles.adapter = Adapter

        searchProfiles()
    }

    private inner class ProfilesItem(val adProfiles: Profiles) : Item<ViewHolder>() {

        override fun getLayout(): Int {
            return R.layout.item_profile_filho
        }


        override fun bind(viewHolder: ViewHolder, position: Int) {

            viewHolder.itemView.name_profile_database.text = adProfiles.nome
//            Picasso.get().load(adProfiles.uid).into(viewHolder.itemView.imageProfile)

            name_profile_database?.setOnClickListener {
                val intent = Intent(it.context, ListOfMoviesActivity::class.java)
                intent.putExtra("profiles", adProfiles)
                it.context.startActivity(intent)
            }

        }
    }

    private fun searchProfiles() {

        FirebaseFirestore.getInstance().collection("Profiles")
            .addSnapshotListener { snapshot, exception ->
                exception?.let {
                    return@addSnapshotListener
                }
                snapshot?.let {
                    for (doc in snapshot) {
                        val profiles = doc.toObject(Profiles::class.java)
                        Adapter.add(ProfilesItem(profiles))
                    }
                }
            }
    }
}