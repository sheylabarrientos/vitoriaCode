package com.sheyla.projeto_integrador.domain

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.sheyla.projeto_integrador.domain.usecase.FavoriteMovie
import java.util.ArrayList

class DatabaseHandler {
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