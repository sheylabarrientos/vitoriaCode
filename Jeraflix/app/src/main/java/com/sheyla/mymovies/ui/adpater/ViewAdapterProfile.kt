package com.sheyla.mymovies.ui.adpater

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sheyla.mymovies.R
import com.sheyla.mymovies.ui.ListOfMoviesActivity
import com.sheyla.mymovies.domain.UserProfile
import com.sheyla.mymovies.ui.fragments.AllMoviesFragment
import com.sheyla.mymovies.ui.fragments.FavoriteMoviesFragment
import com.sheyla.mymovies.ui.fragments.WatchedMoviesFragment
import com.sheyla.mymovies.ui.profile.FragmentProfiles

class ViewAdapterProfile(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 1
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            ALL_PROFILES_POSITION -> FragmentProfiles()
            else -> FragmentProfiles()
        }
    }

    companion object {
        const val ALL_PROFILES_POSITION = 0
    }
}


