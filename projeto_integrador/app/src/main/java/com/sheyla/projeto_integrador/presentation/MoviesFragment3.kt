package com.sheyla.projeto_integrador.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sheyla.projeto_integrador.R

/**
 * A fragment representing a list of Items.
 */

class MoviesFragment3 : Fragment() {
    @Override
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies3, container, false)
    }
}