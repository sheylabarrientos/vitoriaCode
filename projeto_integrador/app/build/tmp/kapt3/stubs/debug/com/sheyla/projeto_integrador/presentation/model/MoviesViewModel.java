package com.sheyla.projeto_integrador.presentation.model;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 52\u00020\u0001:\u00015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u0006J\u0006\u0010(\u001a\u00020&J\u0006\u0010)\u001a\u00020&J\u0014\u0010*\u001a\u00020&2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0005J\u0006\u0010-\u001a\u00020&J\b\u0010.\u001a\u00020&H\u0014J\u000e\u0010/\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u0006J\u000e\u00100\u001a\u00020&2\u0006\u00101\u001a\u000202J\f\u00103\u001a\u000204*\u000204H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0012\u00a8\u00066"}, d2 = {"Lcom/sheyla/projeto_integrador/presentation/model/MoviesViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_favoriteMoviesLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/sheyla/projeto_integrador/domain/Movie;", "_genresLiveData", "Lcom/sheyla/projeto_integrador/domain/Genre;", "_moviesLiveData", "_searchResultsLiveData", "_viewStateLiveData", "Lcom/sheyla/projeto_integrador/presentation/model/ViewState;", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "favoriteMoviesLiveData", "Landroidx/lifecycle/LiveData;", "getFavoriteMoviesLiveData", "()Landroidx/lifecycle/LiveData;", "favoriteMoviesUseCase", "Lcom/sheyla/projeto_integrador/domain/usecase/FavoriteMoviesUseCase;", "genreListLiveData", "getGenreListLiveData", "getAllMoviesUseCase", "Lcom/sheyla/projeto_integrador/domain/usecase/GetAllMoviesUseCase;", "getGenresUseCase", "Lcom/sheyla/projeto_integrador/domain/usecase/GetGenresUseCase;", "getMoviesByGenreUseCase", "Lcom/sheyla/projeto_integrador/domain/usecase/GetMoviesByGenreUseCase;", "movieListLiveData", "getMovieListLiveData", "searchForMoviesUseCase", "Lcom/sheyla/projeto_integrador/domain/usecase/SearchForMovieUseCase;", "searchResultsLiveData", "getSearchResultsLiveData", "viewStateLiveData", "getViewStateLiveData", "addToFavoriteMovie", "", "movie", "getFavoriteMovies", "getGenres", "getMoviesByGenre", "genresId", "", "getPopularMovies", "onCleared", "removeFavoriteMovie", "searchForMovie", "movieSearched", "Landroid/net/Uri;", "handleDisposable", "Lio/reactivex/disposables/Disposable;", "Companion", "app_debug"})
public final class MoviesViewModel extends androidx.lifecycle.ViewModel {
    private final com.sheyla.projeto_integrador.domain.usecase.GetAllMoviesUseCase getAllMoviesUseCase = null;
    private final com.sheyla.projeto_integrador.domain.usecase.GetGenresUseCase getGenresUseCase = null;
    private final com.sheyla.projeto_integrador.domain.usecase.GetMoviesByGenreUseCase getMoviesByGenreUseCase = null;
    private final com.sheyla.projeto_integrador.domain.usecase.FavoriteMoviesUseCase favoriteMoviesUseCase = null;
    private final com.sheyla.projeto_integrador.domain.usecase.SearchForMovieUseCase searchForMoviesUseCase = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> _moviesLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> movieListLiveData = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.sheyla.projeto_integrador.domain.Genre>> _genresLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Genre>> genreListLiveData = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> _favoriteMoviesLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> favoriteMoviesLiveData = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> _searchResultsLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> searchResultsLiveData = null;
    private final androidx.lifecycle.MutableLiveData<com.sheyla.projeto_integrador.presentation.model.ViewState> _viewStateLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.sheyla.projeto_integrador.presentation.model.ViewState> viewStateLiveData = null;
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
    public final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Genre>> getGenreListLiveData() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.sheyla.projeto_integrador.presentation.model.ViewState> getViewStateLiveData() {
        return null;
    }
    
    public final void getPopularMovies() {
    }
    
    public final void getMoviesByGenre(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> genresId) {
    }
    
    public final void getGenres() {
    }
    
    public final void getFavoriteMovies() {
    }
    
    public final void addToFavoriteMovie(@org.jetbrains.annotations.NotNull()
    com.sheyla.projeto_integrador.domain.Movie movie) {
    }
    
    public final void removeFavoriteMovie(@org.jetbrains.annotations.NotNull()
    com.sheyla.projeto_integrador.domain.Movie movie) {
    }
    
    public final void searchForMovie(@org.jetbrains.annotations.NotNull()
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