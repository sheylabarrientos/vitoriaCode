package com.sheyla.projeto_integrador.data.repository

import com.sheyla.projeto_integrador.data.model.Details
import com.sheyla.projeto_integrador.data.modelresponse.*
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

    @GET("movie/{movie_id}/release_dates")
    fun getReleaseDate(@Path("movie_id") movie_id: Int) : Observable<ReleaseDatesResponse> //O comando observa um objeto de tipo "ReleaseDatesResponse", para aí então ativar o código. Foi usado "@Path" pois a documentação assim exige para implementação do "id" (https://developers.themoviedb.org/3/movies/get-movie-details).

    //Link do cast.
    @GET("movie/{movie_id}/credits")
    fun getCast(@Path("movie_id") movie_id2: Int): Observable<ListCast> //O comando observa um objeto de tipo "LisCast", para aí então ativar o código. Foi usado "@Path" pois a documentação assim exige para implementação do "id" (https://developers.themoviedb.org/3/movies/get-movie-credits).

    //Link dos gêneros de filmes.
    @GET("genre/movie/list")
    fun getAllMoviesGenres(): Observable<ListAllMoviesGenres> //O comando observa um objeto de tipo "ListGenresMovies", para aí então ativar o código.

    //Link dos gêneros de cada filme.
    @GET("movie/{movie_id}")
    fun getGenres(@Path("movie_id") movie_id3: Int): Observable<ListAllMoviesGenres> //O comando observa um objeto de tipo "ListGenresMovies", para aí então ativar o código. Foi usado "@Path" pois a documentação assim exige para implementação do "id" (https://developers.themoviedb.org/3/movies/get-movie-details).

    //Link da busca de filme por gênero.
    @GET("discover/movie")
    fun getSelectGenres(@Query("with_genres") movie_id4: String): Observable<Movie> //O comando observa um objeto de tipo "ListMovies", para aí então ativar o código. Foi usado "@Query" pois a documentação assim exige para implementação do "with_genres" (https://developers.themoviedb.org/3/discover/movie-discover).

    //Link do item "runtime" de cada filme.
    @GET("movie/{movie_id}")
    fun getRuntime(@Path("movie_id") movie_id5: Int): Observable<com.sheyla.projeto_integrador.data.modelresponse.Runtime> //O comando observa um objeto de tipo "ListGenresMovies", para aí então ativar o código. Foi usado "@Path" pois a documentação assim exige para implementação do "id" (https://developers.themoviedb.org/3/movies/get-movie-details).

}