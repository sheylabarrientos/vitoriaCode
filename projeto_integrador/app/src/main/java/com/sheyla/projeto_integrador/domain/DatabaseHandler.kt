package com.sheyla.projeto_integrador.domain

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.sheyla.projeto_integrador.domain.usecase.FavoriteMovie
import java.util.ArrayList

class DatabaseHandler {
    companion object{
        var listOfFavoriteMovies = ArrayList<FavoriteMovie>()

        public fun writeFavoriteMovie(movie: Movie){
            val database: DatabaseReference = Firebase.database.reference
            val favoriteMovie: FavoriteMovie = FavoriteMovie()
            favoriteMovie.setId(movie.id)
            favoriteMovie.setTitle(movie.title.toString())

            database.child("favorite movies").child(Integer.toString(favoriteMovie.getId())).setValue(favoriteMovie)
        }

        public fun deleteFavoriteMovie(movie: Movie){
            val database: DatabaseReference = Firebase.database.reference
            val favoriteMovie: FavoriteMovie = FavoriteMovie()
            favoriteMovie.setId(movie.id)
            database.child("favorite movies").child(Integer.toString(favoriteMovie.getId())).removeValue()
        }

        public fun readDataBase(){
            val database: DatabaseReference = Firebase.database.reference
            database.child("favorite movies").get().addOnSuccessListener {
                var counter:Int = 1
                println(it.value.toString())


            //{436969={id=436969, title=O Esquadrão Suicida}, 385128={id=385128, title=Velozes & Furiosos 9}, 379686={id=379686, title=Space Jam: Um Novo Legado}, 451048={id=451048, title=Jungle Cruise}, 497698={id=497698, title=Viúva Negra}}
                var firstList = it.value.toString().split("{id=")
                listOfFavoriteMovies.clear()

                //436969, title=O Esquadrão Suicida}, 385128=

                while(counter < (firstList.size-1)){
                    val newFavoriteMovie:FavoriteMovie = FavoriteMovie()

                    newFavoriteMovie.setId(Integer.parseInt(firstList.get(counter).split(",").get(0)))
                    newFavoriteMovie.setTitle(firstList.get(counter).split("title=").get(1).split("}").get(0))

                    listOfFavoriteMovies.add(newFavoriteMovie)
                    counter++
                }





            }.addOnFailureListener {
                println("unable to read firebase database")
            }
        }
    }
}