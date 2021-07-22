package com.sheyla.projeto_integrador.data.repository

import com.sheyla.projeto_integrador.data.model.Details
import com.sheyla.projeto_integrador.data.modelresponse.MovieResponse
import retrofit2.http.GET
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Path
import retrofit2.http.Query


interface MoviesService {
    @GET("movie/popular")
    fun getMovies(): Observable<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<Details> //two key components: Observable and Observer

    @GET("search/movie")
    fun searchForMovie(@Query("movieSearched") query: String): Observable<MovieResponse>

    @GET("movie/{movie_id}/credits")
    fun getCast()

//    @GET("genre/movie/list")
//    fun getAllGenres(): Observable<CategoryResponse>

    @GET("discover/movie")
    fun getMoviesByGenre(@Query("with_genres", encoded = true) genresId: String): Observable<MovieResponse>

}