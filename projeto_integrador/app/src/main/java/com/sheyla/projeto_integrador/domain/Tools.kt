package com.sheyla.projeto_integrador.domain

import com.sheyla.projeto_integrador.R

class Tools {
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
}