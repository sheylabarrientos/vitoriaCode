package com.sheyla.projeto_integrador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.sheyla.projeto_integrador.presentation.adapter.MoviesCategories
import com.sheyla.projeto_integrador.presentation.adapter.MyMoviesAdapter


lateinit var viewPager: ViewPager
lateinit var tabLayout: TabLayout
lateinit var tabLayoutCategories: TabLayout
lateinit var viewPagerCategories: ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()

        val fragmentAdapter = MyMoviesAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter

        val fragmentAdapterCategories = MoviesCategories(supportFragmentManager)
        viewPagerCategories.adapter = fragmentAdapterCategories

        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)
        tabLayoutCategories.setupWithViewPager(viewPagerCategories)
    }

    private fun bindViews() {
        viewPager = findViewById(R.id.nav_all_favorites_search)
        tabLayout = findViewById(R.id.tab_layout)
        tabLayoutCategories = findViewById(R.id.tab_layout_categories)
        viewPagerCategories = findViewById(R.id.view_Pager_Categories)
    }

//        class MyMoviesFragment : Fragment() {
//        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//                tab.text = "Todos os Filmes ${(position + 1)}"
//            }.attach()
//        }
//    }
}