package com.sheyla.mymovies.presentation.adpater


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sheyla.mymovies.presentation.fragments.AllMoviesFragment
import com.sheyla.mymovies.presentation.fragments.FavoriteMoviesFragment

class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            ALL_MOVIES_POSITION -> AllMoviesFragment()
            FAVORITE_MOVIES_POSITION -> FavoriteMoviesFragment()
            MOVIES_WATCHED -> FavoriteMoviesFragment()
            else -> FavoriteMoviesFragment()
        }
    }

    companion object {
        const val ALL_MOVIES_POSITION = 0
        const val FAVORITE_MOVIES_POSITION = 1
        const val MOVIES_WATCHED = 2
    }
}

