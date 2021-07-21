package com.sheyla.projeto_integrador.presentation.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sheyla.projeto_integrador.R
import com.sheyla.projeto_integrador.presentation.home.view.adapter.MoviesCategoriesAdapter


lateinit var viewPager: ViewPager2
lateinit var tabLayout: TabLayout
lateinit var tabLayoutCategories: TabLayout
lateinit var viewPagerCategories: ViewPager2


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()

        val viewpager = findViewById<ViewPager2>(R.id.view_Pager_Categories)
        viewpager.adapter = MoviesCategoriesAdapter(this)

        val tablayout = findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tablayout, viewpager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()
        viewpager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
            }
        })

    }

    private fun bindViews() {
        viewPager = findViewById(R.id.nav_all_favorites_search)
        tabLayout = findViewById(R.id.tab_layout)
        tabLayoutCategories = findViewById(R.id.tab_layout_categories)
        viewPagerCategories = findViewById(R.id.view_Pager_Categories)


    }

    private fun getTabTitle(position: Int): String {
        return when (position) {
            0 -> "Todos os filmes"
            1 -> "Favoritos"
            else -> "Modo Pesquisa"
        }
    }


    fun searchMovies() {

    }

    fun allMovies() {

    }

    fun favoriteMovies() {

    }

    fun moviesForCategories() {

    }

//        class MyMoviesFragment : Fragment() {
//        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//                tab.text = "Todos os Filmes ${(position + 1)}"
//            }.attach()
//        }
//    }

}