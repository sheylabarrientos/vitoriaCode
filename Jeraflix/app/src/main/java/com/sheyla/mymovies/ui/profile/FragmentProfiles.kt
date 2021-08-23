package com.sheyla.mymovies.ui.profile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.FirebaseFirestore
import com.sheyla.mymovies.R
import com.sheyla.mymovies.domain.Profiles
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_profiles.*
import kotlinx.android.synthetic.main.activity_profiles.view.*
import kotlinx.android.synthetic.main.item_profile_filho.view.*

class FragmentProfiles : Fragment() {

    private lateinit var Adapter: GroupAdapter<ViewHolder>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Adapter = GroupAdapter()
        rcvProfiles.adapter = Adapter

        searchProfiles()
    }

    private inner class ProfilesItem(internal val adProfiles: Profiles) : Item<ViewHolder>() {

        @SuppressLint("ResourceType")
        override fun getLayout(): Int {
            return R.id.rcvProfiles
        }


        override fun bind(viewHolder: ViewHolder, position: Int) {

            viewHolder.itemView.name_profile_database.text = adProfiles.nome

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