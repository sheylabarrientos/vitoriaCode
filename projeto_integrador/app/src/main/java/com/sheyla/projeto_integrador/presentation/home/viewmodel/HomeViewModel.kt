package com.sheyla.projeto_integrador.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sheyla.projeto_integrador.data.model.FetchMoviesUseCase
import com.sheyla.projeto_integrador.data.modelresponse.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel() : ViewModel() {

    private val movieList = MutableLiveData<List<Movie>>(mutableListOf()) //QUEM VÊ É A VIEWMODEL. Talvez esse "mutablelistof" não seja necessáiro incluir.
    val moviesListResult : LiveData<List<Movie>> = movieList //QUEM VÊ É A ACTIVITY
    val disposable = CompositeDisposable()
    private val useCase: FetchMoviesUseCase = FetchMoviesUseCase()

    fun getMovies(){
        useCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                movieList.value = it.movies
            }, {
            it.message
        })
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}