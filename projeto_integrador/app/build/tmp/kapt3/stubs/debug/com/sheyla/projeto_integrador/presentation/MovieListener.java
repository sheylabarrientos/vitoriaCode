package com.sheyla.projeto_integrador.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H&\u00a8\u0006\u000e"}, d2 = {"Lcom/sheyla/projeto_integrador/presentation/MovieListener;", "", "loadMoviesWithGenre", "", "genreIds", "", "", "onFavoriteClickedListener", "movie", "Lcom/sheyla/projeto_integrador/domain/Movie;", "isChecked", "", "openMovieDetails", "movieId", "app_debug"})
public abstract interface MovieListener {
    
    public abstract void openMovieDetails(int movieId);
    
    public abstract void loadMoviesWithGenre(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> genreIds);
    
    public abstract void onFavoriteClickedListener(@org.jetbrains.annotations.NotNull()
    com.sheyla.projeto_integrador.domain.Movie movie, boolean isChecked);
}