package com.sheyla.projeto_integrador

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

lateinit var viewPager: ViewPager2
lateinit var tabLayout: TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
    }

        class MoviesFragment : Fragment() {
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = "Todos os Filmes ${(position + 1)}"
            }.attach()
        }
    }
}