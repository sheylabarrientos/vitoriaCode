package com.sheyla.projeto_integrador.data.repository

import com.sheyla.projeto_integrador.data.model.Details
import com.sheyla.projeto_integrador.data.model.Movies
import retrofit2.http.GET
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Path


interface MoviesService {
    @GET("movie/{popular}")
    fun getMovies(): Observable<Movies>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<Details> //two key components: Observable and Observer
}