package com.sheyla.projeto_integrador.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sheyla.projeto_integrador.domain.Cast
import com.sheyla.projeto_integrador.domain.Certification
import com.sheyla.projeto_integrador.domain.Movie
import com.sheyla.projeto_integrador.domain.MovieDetail
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

class MovieDetailsViewModel : ViewModel() {


    private val _movieLiveData = MutableLiveData<MovieDetail>()
    val movieLiveData: LiveData<MovieDetail> = _movieLiveData

    private val _castLiveData = MutableLiveData<List<Cast>>()
    val castLiveData: LiveData<List<Cast>> = _castLiveData

    private val _certificationLiveData = MutableLiveData<List<Certification>>()
    val certificationLiveData: LiveData<List<Certification>> = _certificationLiveData

    private val _favoriteMoviesLiveData = MutableLiveData<List<Movie>>(mutableListOf())
    val favoriteMoviesLiveData : LiveData<List<Movie>> = _favoriteMoviesLiveData


    private val disposable = CompositeDisposable()

    fun getMovieDetails(movieId: Int){

    }

    fun getCast(movieId: Int){

    }

    fun getCertification(movieId: Int){

    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

    private fun Disposable.handleDisposable(): Disposable = apply { disposable.add(this) }
}