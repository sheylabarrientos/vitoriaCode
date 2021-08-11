package com.sheyla.projeto_integrador.presentation.home.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sheyla.projeto_integrador.presentation.home.AllMoviesFragment
import com.sheyla.projeto_integrador.presentation.favorite.FavoriteMoviesFragment


class ViewPagerAdapter (fa: FragmentActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AllMoviesFragment()
            else -> FavoriteMoviesFragment()
        }
    }

}

