package com.sheyla.mymovies.ui.adpater

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
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


