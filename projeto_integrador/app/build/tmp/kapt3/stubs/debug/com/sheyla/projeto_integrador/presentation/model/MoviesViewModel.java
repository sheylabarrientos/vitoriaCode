package com.sheyla.projeto_integrador.presentation.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \'2\u00020\u0001:\u0001\'B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006J\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0018J\u0014\u0010\u001d\u001a\u00020\u00182\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0005J\b\u0010 \u001a\u00020\u0018H\u0014J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020$J\f\u0010%\u001a\u00020&*\u00020&H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010\u00a8\u0006("}, d2 = {"Lcom/sheyla/projeto_integrador/presentation/model/MoviesViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_favoriteMoviesLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/sheyla/projeto_integrador/domain/Movie;", "_genresLiveData", "Lcom/sheyla/projeto_integrador/domain/Category;", "_moviesLiveData", "_searchResultsLiveData", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "favoriteMoviesLiveData", "Landroidx/lifecycle/LiveData;", "getFavoriteMoviesLiveData", "()Landroidx/lifecycle/LiveData;", "genreListLiveData", "getGenreListLiveData", "movieListLiveData", "getMovieListLiveData", "searchResultsLiveData", "getSearchResultsLiveData", "addToFavoriteMovie", "", "movie", "getAllMovies", "getCategories", "getFavoriteMovies", "getMoviesByCategory", "genresId", "", "onCleared", "removeMovieFavorite", "searchMovie", "movieSearched", "Landroid/net/Uri;", "handleDisposable", "Lio/reactivex/disposables/Disposable;", "Companion", "app_debug"})
public final class MoviesViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> _moviesLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> movieListLiveData = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.sheyla.projeto_integrador.domain.Category>> _genresLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Category>> genreListLiveData = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> _favoriteMoviesLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> favoriteMoviesLiveData = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> _searchResultsLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> searchResultsLiveData = null;
    private final io.reactivex.disposables.CompositeDisposable disposable = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.sheyla.projeto_integrador.presentation.model.MoviesViewModel.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    private static java.util.ArrayList<com.sheyla.projeto_integrador.domain.FavoriteMovie> listOfFavoriteMovies;
    
    public MoviesViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> getMovieListLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Category>> getGenreListLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> getFavoriteMoviesLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> getSearchResultsLiveData() {
        return null;
    }
    
    public final void getAllMovies() {
    }
    
    public final void getMoviesByCategory(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> genresId) {
    }
    
    public final void getCategories() {
    }
    
    public final void getFavoriteMovies() {
    }
    
    public final void addToFavoriteMovie(@org.jetbrains.annotations.NotNull()
    com.sheyla.projeto_integrador.domain.Movie movie) {
    }
    
    public final void removeMovieFavorite(@org.jetbrains.annotations.NotNull()
    com.sheyla.projeto_integrador.domain.Movie movie) {
    }
    
    public final void searchMovie(@org.jetbrains.annotations.NotNull()
    android.net.Uri movieSearched) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    private final io.reactivex.disposables.Disposable handleDisposable(io.reactivex.disposables.Disposable $this$handleDisposable) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/sheyla/projeto_integrador/presentation/model/MoviesViewModel$Companion;", "", "()V", "listOfFavoriteMovies", "Ljava/util/ArrayList;", "Lcom/sheyla/projeto_integrador/domain/FavoriteMovie;", "getListOfFavoriteMovies", "()Ljava/util/ArrayList;", "setListOfFavoriteMovies", "(Ljava/util/ArrayList;)V", "deleteFavoriteMovie", "", "movie", "Lcom/sheyla/projeto_integrador/domain/Movie;", "movieIdIsFavorite", "", "id", "", "readDataBase", "writeFavoriteMovie", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<com.sheyla.projeto_integrador.domain.FavoriteMovie> getListOfFavoriteMovies() {
            return null;
        }
        
        public final void setListOfFavoriteMovies(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.sheyla.projeto_integrador.domain.FavoriteMovie> p0) {
        }
        
        public final void writeFavoriteMovie(@org.jetbrains.annotations.NotNull()
        com.sheyla.projeto_integrador.domain.Movie movie) {
        }
        
        public final boolean movieIdIsFavorite(int id) {
            return false;
        }
        
        public final void deleteFavoriteMovie(@org.jetbrains.annotations.NotNull()
        com.sheyla.projeto_integrador.domain.Movie movie) {
        }
        
        public final void readDataBase() {
        }
    }
}