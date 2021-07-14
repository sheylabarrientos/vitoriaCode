package com.sheyla.projeto_integrador.presentation.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.sheyla.projeto_integrador.presentation.MoviesFragment
import com.sheyla.projeto_integrador.presentation.MoviesFragment2
import com.sheyla.projeto_integrador.presentation.MoviesFragment3


class MoviesCategoriesAdapter (fm: FragmentManager) : FragmentPagerAdapter (fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                MoviesFragment()
            }
            1 -> {
                MoviesFragment2()
            }
            else -> {
                return MoviesFragment3()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> {
                "Ação"
            }
            1 -> {
                "Anime"
            }
            2 -> {
                "Comédia"
            }
            else -> {
                "Drama"
            }
        }
    }
}

