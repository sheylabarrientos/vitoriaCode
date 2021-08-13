package com.sheyla.projeto_integrador.domain

import com.sheyla.projeto_integrador.R

class MovieDetail(
    val backdrop_path: String? = null,
    val genres: List<Genre>,
    val id: Int,
    val overview: String? = null,
    val release_date: String,
    val runtime: Int? = null,
    val vote_average: Float,
    val title: String,
    var isFavorite: Boolean = false,
) {

    companion object{
        var searchID:Int = R.id.searchMovie

        fun timeConversion(runtime: Int): String{
            val time = runtime/60
            val onlyHours = time.toString().substringBefore(".").toInt()
            val onlyMinutes = runtime - (onlyHours * 60)
            return if(onlyHours == 0){
                onlyMinutes.toString()+"min"
            }else{
                onlyHours.toString()+"h "+onlyMinutes.toString()+"min"
            }
        }

        fun ratingConversion(vote_average: Float): String{
            val rating = (vote_average*10).toInt().toString()
            return "$rating%"
        }

    }

    fun getRating(): String {
        val rating = (vote_average * 10).toInt()
        return "$rating%"
    }

    fun getReleaseYear(): String {
        return release_date.take(4)
    }

    fun getRuntime(): String {
        runtime?.let {
            return if (runtime < 60) {
                runtime.toString() + "min"
            } else {
                val time = runtime / 60
                val hours = time.toString().substringBefore(".").toInt()
                val minutes = runtime - (hours * 60)
                hours.toString() +
                        "h " +
                        minutes.toString() +
                        "min"
            }
        }
        return ""
    }
}