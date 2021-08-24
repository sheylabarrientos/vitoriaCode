package com.sheyla.mymovies.ui.profile


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.HttpMethod
import com.facebook.login.LoginManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.sheyla.mymovies.R
import com.sheyla.mymovies.databinding.ActivitySelectProfilesBinding
import com.sheyla.mymovies.ui.adpater.ViewAdapterProfile
import com.sheyla.mymovies.ui.login.FormLogin


class SelectProfilesActivity : AppCompatActivity() {

    private lateinit var tbLytOptionsProfile: TabLayout
    private lateinit var viewPagerProfile: ViewPager2
    private lateinit var binding: ActivitySelectProfilesBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectProfilesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindViews()
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

        viewPagerProfile.adapter = ViewAdapterProfile(this)
        viewPagerProfile.isUserInputEnabled = false
        TabLayoutMediator(tbLytOptionsProfile, viewPagerProfile) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.disconnect -> {
                FirebaseAuth.getInstance().signOut()
                backScreenLogin()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun backScreenLogin() {
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()

        if (AccessToken.getCurrentAccessToken() != null) {
            GraphRequest(
                AccessToken.getCurrentAccessToken(),
                "/me/permissions/",
                null,
                HttpMethod.DELETE,
                GraphRequest.Callback {
                    AccessToken.setCurrentAccessToken(null)
                    LoginManager.getInstance().logOut()

                    finish()
                }).executeAsync()
        }
    }
}