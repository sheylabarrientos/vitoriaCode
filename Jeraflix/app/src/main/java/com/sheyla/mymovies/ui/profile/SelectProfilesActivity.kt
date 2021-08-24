package com.sheyla.mymovies.ui.profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.sheyla.mymovies.R
import com.sheyla.mymovies.ui.adpater.ViewAdapterProfile


class SelectProfilesActivity : AppCompatActivity() {

    private lateinit var tbLytOptionsProfile: TabLayout
    private lateinit var viewPagerProfile: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_profiles)
        bindViews()

//        btnBack.setOnClickListener { finish() }

        }

    private fun getTabTitle(position: Int): String {
        return when (position) {
            ViewAdapterProfile.ALL_PROFILES_POSITION -> "Profiles"
            else -> ""
        }
    }

    private fun bindViews() {
        tbLytOptionsProfile = findViewById(R.id.tabLytOptionsProfile)
        viewPagerProfile = findViewById(R.id.viewPagerProfile)

        viewPagerProfile.adapter = ViewAdapterProfile (this)
        viewPagerProfile.isUserInputEnabled = false
        TabLayoutMediator(tbLytOptionsProfile, viewPagerProfile) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()
    }


    private fun backToProfiles(){
        val intent = Intent(this,ProfilesActivity::class.java)
        startActivity(intent)
        finish()
    }
}