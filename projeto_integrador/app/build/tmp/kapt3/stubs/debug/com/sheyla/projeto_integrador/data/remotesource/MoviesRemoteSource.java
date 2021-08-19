package com.sheyla.projeto_integrador.data.remotesource;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH\'J\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH\'J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH\'J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\'J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003H\'J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u0014H\'\u00a8\u0006\u0015"}, d2 = {"Lcom/sheyla/projeto_integrador/data/remotesource/MoviesRemoteSource;", "", "getAllGenres", "Lio/reactivex/Single;", "Lcom/sheyla/projeto_integrador/data/model/categories/ResponseGenres;", "getCast", "Lcom/sheyla/projeto_integrador/data/model/cast/ResponseCast;", "movieId", "", "getCertification", "Lcom/sheyla/projeto_integrador/data/model/certification/ResponseCertification;", "getMovieDetails", "Lcom/sheyla/projeto_integrador/data/model/movies/MovieDetailResponse;", "getMoviesByGenre", "Lcom/sheyla/projeto_integrador/data/model/movies/ResponseMovies;", "genresId", "", "getPopularMovies", "searchForMovie", "movieSearched", "Landroid/net/Uri;", "app_debug"})
public abstract interface MoviesRemoteSource {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "movie/popular")
    public abstract io.reactivex.Single<com.sheyla.projeto_integrador.data.model.movies.ResponseMovies> getPopularMovies();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "movie/{movie_id}")
    public abstract io.reactivex.Single<com.sheyla.projeto_integrador.data.model.movies.MovieDetailResponse> getMovieDetails(@retrofit2.http.Path(value = "movie_id")
    int movieId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "search/movie")
    public abstract io.reactivex.Single<com.sheyla.projeto_integrador.data.model.movies.ResponseMovies> searchForMovie(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "query")
    android.net.Uri movieSearched);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "movie/{movie_id}/credits")
    public abstract io.reactivex.Single<com.sheyla.projeto_integrador.data.model.cast.ResponseCast> getCast(@retrofit2.http.Path(value = "movie_id")
    int movieId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "genre/movie/list")
    public abstract io.reactivex.Single<com.sheyla.projeto_integrador.data.model.categories.ResponseGenres> getAllGenres();
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "movie/{movie_id}/release_dates")
    public abstract io.reactivex.Single<com.sheyla.projeto_integrador.data.model.certification.ResponseCertification> getCertification(@retrofit2.http.Path(value = "movie_id")
    int movieId);
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "discover/movie")
    public abstract io.reactivex.Single<com.sheyla.projeto_integrador.data.model.movies.ResponseMovies> getMoviesByGenre(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "with_genres", encoded = true)
    java.lang.String genresId);
}