package com.sheyla.projeto_integrador.presentation.home.view.adapter


import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sheyla.projeto_integrador.presentation.home.view.MoviesFragment
import com.sheyla.projeto_integrador.presentation.home.view.MainActivity


class MoviesCategoriesAdapter (fa: MainActivity) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MoviesFragment()
            1 -> MoviesFragment()
            else -> MoviesFragment()
        }
    }

}

