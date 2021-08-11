package com.sheyla.projeto_integrador.presentation

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sheyla.projeto_integrador.domain.Genre
import com.sheyla.projeto_integrador.domain.Movie
import com.sheyla.projeto_integrador.domain.usecase.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.sheyla.projeto_integrador.presentation.model.ViewState

class MoviesViewModel() : ViewModel() {

    private val getAllMoviesUseCase = GetAllMoviesUseCase()
    private val getGenresUseCase = GetGenresUseCase()
    private val getMoviesByGenreUseCase = GetMoviesByGenreUseCase()
    private val favoriteMoviesUseCase = FavoriteMoviesUseCase()
    private val searchForMoviesUseCase = SearchForMovieUseCase()

    private val _moviesLiveData = MutableLiveData<List<Movie>>(mutableListOf())
    val movieListLiveData : LiveData<List<Movie>> = _moviesLiveData

    private val _genresLiveData = MutableLiveData<List<Genre>>()
    val genreListLiveData : LiveData<List<Genre>> = _genresLiveData

    private val _favoriteMoviesLiveData = MutableLiveData<List<Movie>>(mutableListOf())
    val favoriteMoviesLiveData : LiveData<List<Movie>> = _favoriteMoviesLiveData

    private val _searchResultsLiveData = MutableLiveData<List<Movie>>(mutableListOf())
    val searchResultsLiveData : LiveData<List<Movie>> = _searchResultsLiveData

    private val _viewStateLiveData = MutableLiveData<ViewState>()
    val viewStateLiveData : LiveData<ViewState> = _viewStateLiveData

    private val disposable = CompositeDisposable()

    fun getPopularMovies(){
        getAllMoviesUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {result ->
                    _moviesLiveData.value = result
                },
                { error ->
                    Log.e("ErroReq", "erro: " + error.cause)
                    _viewStateLiveData.value = ViewState.GeneralError
                }
            ).handleDisposable()
    }

    fun getMoviesByGenre(genresId: List<Int>){
        getMoviesByGenreUseCase.executeMoviesByGenre(genresId.joinToString(","))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                {result ->
                    _moviesLiveData.value = result
                },
                {
                    Log.e("ErroReq", "erro: " + it.cause)
                    _viewStateLiveData.value = ViewState.GeneralError
                }
            ).handleDisposable()
    }

    fun getGenres(){
        getGenresUseCase.executeGenres()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {result ->
                    _genresLiveData.value = result
                },
                {
                    Log.e("ErroReq", "erro: " + it.cause)
                    _viewStateLiveData.value = ViewState.GeneralError
                }
            ).handleDisposable()
    }

    fun getFavoriteMovies(){
        favoriteMoviesUseCase.getFavoriteMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _favoriteMoviesLiveData.value = it
                },
                {
                    print(it.message)
                }
            ).handleDisposable()
    }

    fun favoriteMovie(movie: Movie){
        favoriteMoviesUseCase.addFavoriteMovie(movie)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _favoriteMoviesLiveData.value = it
                    //checkFavorites()
                },
                {
                    print(it.message)
                }
            ).handleDisposable()
    }

    fun unfavoriteMovie(movie: Movie){
        favoriteMoviesUseCase.removeFavoriteMovie(movie)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _favoriteMoviesLiveData.value = it
                    //checkFavorites()
                },
                {
                    print(it.message)
                }
            ).handleDisposable()
    }

    fun searchForMovie(movieSearched: Uri){
        searchForMoviesUseCase.executeSearch(movieSearched)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            //.timeout(5, TimeUnit.SECONDS)
            .subscribe(
                {
                    _searchResultsLiveData.value = it
                    if (it.isEmpty()) {
                        _viewStateLiveData.value = ViewState.MovieNotFound
                    }
                },
                {
                    Log.e("ErrorSearch", "Mensagem do erro: " + it.message)
                    _viewStateLiveData.value = ViewState.GeneralError
                }
            ).handleDisposable()
    }

    fun checkFavorites(){
        favoriteMoviesLiveData.value?.forEach{ movie ->
            favoriteMoviesUseCase.isFavorite(movie)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ result ->
                    movie.isFavorite = result
                }
        }
    }

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

    private fun Disposable.handleDisposable(): Disposable = apply { disposable.add(this) }

}