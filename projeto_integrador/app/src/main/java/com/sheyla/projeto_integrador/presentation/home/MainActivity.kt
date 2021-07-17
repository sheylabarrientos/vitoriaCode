package com.sheyla.projeto_integrador.presentation.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.sheyla.projeto_integrador.R
import com.sheyla.projeto_integrador.presentation.Movie
import com.sheyla.projeto_integrador.presentation.MoviesFragment
import com.sheyla.projeto_integrador.presentation.adapter.Adapter
import com.sheyla.projeto_integrador.presentation.adapter.MoviesCategoriesAdapter


lateinit var viewPager: ViewPager
lateinit var tabLayout: TabLayout
lateinit var tabLayoutCategories: TabLayout
lateinit var viewPagerCategories: ViewPager


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()

        val fragmentAdapterCategories = MoviesCategoriesAdapter(supportFragmentManager)
        viewPagerCategories.adapter = fragmentAdapterCategories

        tabLayout.setupWithViewPager(viewPager)
        tabLayoutCategories.setupWithViewPager(viewPagerCategories)

    }

    private fun bindViews() {
        viewPager = findViewById(R.id.nav_all_favorites_search)
        tabLayout = findViewById(R.id.tab_layout)
        tabLayoutCategories = findViewById(R.id.tab_layout_categories)
        viewPagerCategories = findViewById(R.id.view_Pager_Categories)


    }

//    private fun showFragmentMovie() {
//        val intent = Intent(this, MoviesFragment::class.java)
//        intent.putStringArrayListExtra("MOVIES", movies)
//        startActivity(intent)
//    }


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