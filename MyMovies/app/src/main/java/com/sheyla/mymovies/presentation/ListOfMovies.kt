package com.sheyla.mymovies.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.core.net.toUri
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import com.sheyla.mymovies.R
import com.sheyla.mymovies.databinding.ActivityLisfOfMoviesBinding
import com.sheyla.mymovies.presentation.adpater.ViewPagerAdapter
import com.sheyla.mymovies.presentation.model.MoviesViewModel
import com.sheyla.mymovies.presentation.adpater.ViewPagerAdapter.Companion.ALL_MOVIES_POSITION
import com.sheyla.mymovies.presentation.adpater.ViewPagerAdapter.Companion.FAVORITE_MOVIES_POSITION
import com.sheyla.mymovies.presentation.adpater.ViewPagerAdapter.Companion.MOVIES_WATCHED
import com.sheyla.projeto_integrador.presentation.searchmovies.SearchMoviesFragment


class ListOfMovies : AppCompatActivity() {

    private var searchEdtTxt: EditText? = null
    private lateinit var searchBtn: ImageButton
    private lateinit var greenIcon: ImageView
    private lateinit var searchModeTxt: TextView
    private lateinit var backToHomeBtn: TextView
    private lateinit var tbLytOptions: TabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var fragmentContainer: FrameLayout
    private lateinit var movieSearched: String
    private var searchFragment: SearchMoviesFragment? = null

    private lateinit var binding: ActivityLisfOfMoviesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLisfOfMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MoviesViewModel.readDataBase()
        bindViews()

    }

    private fun getTabTitle(position: Int): String {
        return when (position) {
            ALL_MOVIES_POSITION -> "Sugestões"
            FAVORITE_MOVIES_POSITION -> "Assistir"
            MOVIES_WATCHED -> "Assistidos"
            else -> ""
        }
    }

    private fun visibilitySearchMode(){
        tbLytOptions.visibility = View.GONE
        viewPager.visibility = View.GONE
        greenIcon.visibility = View.VISIBLE
        searchModeTxt.visibility = View.VISIBLE
        backToHomeBtn.visibility = View.VISIBLE
        fragmentContainer.visibility = View.VISIBLE
    }

    private fun visibilityNotSearchMode(){
        tbLytOptions.visibility = View.VISIBLE
        viewPager.visibility = View.VISIBLE
        fragmentContainer.visibility = View.GONE
        greenIcon.visibility = View.GONE
        searchModeTxt.visibility = View.GONE
        backToHomeBtn.visibility = View.GONE
    }


private fun bindViews(){
    searchEdtTxt = findViewById(R.id.searchMovie)
    searchBtn = findViewById(R.id.submitSearch)
    tbLytOptions = findViewById(R.id.tabLytOptions)
    viewPager = findViewById(R.id.viewPager)
    greenIcon = findViewById(R.id.greenIcon)
    searchModeTxt = findViewById(R.id.searchModeTxt)
    backToHomeBtn = findViewById(R.id.backToHomeBtn)
    fragmentContainer = findViewById(R.id.searchFragmentContainer)

    viewPager.adapter = ViewPagerAdapter(this)
    viewPager.isUserInputEnabled = false
    TabLayoutMediator(tbLytOptions, viewPager) { tab, position ->
        tab.text = getTabTitle(position)
    }.attach()

    searchEdtTxt?.setOnEditorActionListener { _, actionId, _ ->
        when(actionId) {
            EditorInfo.IME_ACTION_SEARCH -> {
                movieSearched = searchEdtTxt?.text.toString()
                if(searchFragment == null) {
                    searchFragment = SearchMoviesFragment.newInstance(movieSearched)
                    searchFragment?.let{
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.searchFragmentContainer, it)
                            //.addToBackStack(null)
                            .commit()
                    }
                }
                else {
                    searchFragment?.updateQuery(movieSearched.toUri())
                }
                true}
            else -> false
        }
    }

    searchEdtTxt?.addTextChangedListener(object: TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) { }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            visibilitySearchMode()
        }

        override fun afterTextChanged(s: Editable?) {
            if (s != null) {
                if (s.isEmpty()) {
                    viewPager.setCurrentItem(ALL_MOVIES_POSITION, false)
                    visibilityNotSearchMode()
                }
            }
        }
    })

    backToHomeBtn.setOnClickListener {
        visibilityNotSearchMode()
        searchEdtTxt?.text?.clear()
    }
}

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
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
    }
}