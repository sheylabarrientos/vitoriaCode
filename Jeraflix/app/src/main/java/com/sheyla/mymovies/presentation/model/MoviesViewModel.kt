package com.sheyla.mymovies.presentation.model

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.sheyla.mymovies.domain.FavoriteMovie
import com.sheyla.mymovies.domain.Genre
import com.sheyla.mymovies.domain.Movie
import com.sheyla.mymovies.domain.usecase.FavoriteMoviesUseCase
import com.sheyla.mymovies.domain.usecase.GetAllMoviesUseCase
import com.sheyla.mymovies.domain.usecase.GetMoviesByGenreUseCase
import com.sheyla.mymovies.domain.usecase.SearchForMovieUseCase
import com.sheyla.mymoviesdomain.usecase.GetCategoriesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.ArrayList

class MoviesViewModel() : ViewModel() {

    private val getAllMoviesUseCase = GetAllMoviesUseCase()
    private val getGenresUseCase = GetCategoriesUseCase()
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

    fun addToFavoriteMovie(movie: Movie){
        favoriteMoviesUseCase.addToFavoriteMovie(movie)
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

    fun removeFavoriteMovie(movie: Movie){
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

    override fun onCleared() {
        disposable.dispose()
        super.onCleared()
    }

    private fun Disposable.handleDisposable(): Disposable = apply { disposable.add(this) }


    companion object {
        var listOfFavoriteMovies = ArrayList<FavoriteMovie>()

        fun writeFavoriteMovie(movie: Movie) {
            val database: DatabaseReference = Firebase.database.reference
            val favoriteMovie = FavoriteMovie()
            favoriteMovie.setId(movie.id)
            favoriteMovie.setTitle(movie.title.toString())

            database.child("favorite movies").child(Integer.toString(favoriteMovie.getId()))
                .setValue(favoriteMovie)
        }

        fun movieIdIsFavorite(id: Int): Boolean {
            var i = 0

            while (i < listOfFavoriteMovies.size) {
                if (listOfFavoriteMovies[i].getId() == id) {
                    return true
                }
                i++
            }
            return false
        }

        fun deleteFavoriteMovie(movie: Movie) {
            val database: DatabaseReference = Firebase.database.reference
            val favoriteMovie = FavoriteMovie()
            favoriteMovie.setId(movie.id)
            database.child("favorite movies").child(Integer.toString(favoriteMovie.getId()))
                .removeValue()
        }

        fun readDataBase() {
            val database: DatabaseReference = Firebase.database.reference
            database.child("favorite movies").get().addOnSuccessListener {
                var counter = 1
                println(it.value.toString())
                val firstList = it.value.toString().split("{id=")
                listOfFavoriteMovies.clear()

                while (counter < (firstList.size - 1)) {
                    val newFavoriteMovie = FavoriteMovie()

                    newFavoriteMovie.setId(
                        Integer.parseInt(
                            firstList[counter].split(",").get(0)
                        )
                    )
                    newFavoriteMovie.setTitle(
                        firstList[counter].split("title=").get(1).split("}").get(0)
                    )

                    listOfFavoriteMovies.add(newFavoriteMovie)
                    counter++
                }

            }.addOnFailureListener {
                println("unable to read firebase database")
            }
        }
    }

}