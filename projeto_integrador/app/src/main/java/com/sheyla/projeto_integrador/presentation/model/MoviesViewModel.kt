package com.sheyla.projeto_integrador.presentation.model

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.sheyla.projeto_integrador.domain.Category
import com.sheyla.projeto_integrador.domain.FavoriteMovie
import com.sheyla.projeto_integrador.domain.Movie
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.ArrayList

class MoviesViewModel() : ViewModel() {

    private val _moviesLiveData = MutableLiveData<List<Movie>>(mutableListOf())
    val movieListLiveData : LiveData<List<Movie>> = _moviesLiveData

    private val _genresLiveData = MutableLiveData<List<Category>>()
    val genreListLiveData : LiveData<List<Category>> = _genresLiveData

    private val _favoriteMoviesLiveData = MutableLiveData<List<Movie>>(mutableListOf())
    val favoriteMoviesLiveData : LiveData<List<Movie>> = _favoriteMoviesLiveData

    private val _searchResultsLiveData = MutableLiveData<List<Movie>>(mutableListOf())
    val searchResultsLiveData : LiveData<List<Movie>> = _searchResultsLiveData


    private val disposable = CompositeDisposable()

    fun getAllMovies(){

    }

    fun getMoviesByCategory(genresId: List<Int>){

    }

    fun getCategories(){

    }

    fun getFavoriteMovies(){

    }

    fun addToFavoriteMovie(movie: Movie){

    }

    fun removeMovieFavorite(movie: Movie){

    }

    fun searchMovie(movieSearched: Uri){

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