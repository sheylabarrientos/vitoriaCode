package com.sheyla.projeto_integrador.data.repository

import com.sheyla.projeto_integrador.data.model.Movies
import retrofit2.http.GET
import io.reactivex.Observable


interface MoviesService {
    @GET("movie/popular")
    fun getMovies(): Observable<Movies>
}