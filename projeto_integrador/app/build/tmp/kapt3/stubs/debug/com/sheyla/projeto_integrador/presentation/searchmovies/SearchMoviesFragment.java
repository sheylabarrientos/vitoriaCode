package com.sheyla.projeto_integrador.presentation.searchmovies;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J&\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u001a\u0010&\u001a\u00020\u00132\u0006\u0010\'\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0016H\u0016J\u000e\u0010*\u001a\u00020\u00132\u0006\u0010+\u001a\u00020,R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/sheyla/projeto_integrador/presentation/searchmovies/SearchMoviesFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/sheyla/projeto_integrador/presentation/MovieListener;", "()V", "genresAdapter", "Lcom/sheyla/projeto_integrador/presentation/adpater/GenresRvAdapter;", "movieNotFound", "Landroid/view/View;", "movieSearched", "", "moviesAdapter", "Lcom/sheyla/projeto_integrador/presentation/adpater/MoviesRvAdapter;", "moviesViewModel", "Lcom/sheyla/projeto_integrador/presentation/model/MoviesViewModel;", "progressBar", "Landroid/widget/ProgressBar;", "rvMovies", "Landroidx/recyclerview/widget/RecyclerView;", "loadMoviesWithGenre", "", "genreIds", "", "", "observeGenres", "observeMovies", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onFavoriteClickedListener", "movie", "Lcom/sheyla/projeto_integrador/domain/Movie;", "isChecked", "", "onViewCreated", "view", "openMovieDetails", "movieId", "updateQuery", "query", "Landroid/net/Uri;", "Companion", "app_debug"})
public final class SearchMoviesFragment extends androidx.fragment.app.Fragment implements com.sheyla.projeto_integrador.presentation.MovieListener {
    private java.lang.String movieSearched;
    private com.sheyla.projeto_integrador.presentation.adpater.MoviesRvAdapter moviesAdapter;
    private com.sheyla.projeto_integrador.presentation.adpater.GenresRvAdapter genresAdapter;
    private android.widget.ProgressBar progressBar;
    private android.view.View movieNotFound;
    private androidx.recyclerview.widget.RecyclerView rvMovies;
    private com.sheyla.projeto_integrador.presentation.model.MoviesViewModel moviesViewModel;
    @org.jetbrains.annotations.NotNull()
    public static final com.sheyla.projeto_integrador.presentation.searchmovies.SearchMoviesFragment.Companion Companion = null;
    private static final java.lang.String ARG_PARAM1 = "movieSearched";
    private java.util.HashMap _$_findViewCache;
    
    public SearchMoviesFragment() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void updateQuery(@org.jetbrains.annotations.NotNull()
    android.net.Uri query) {
    }
    
    private final void observeMovies() {
    }
    
    private final void observeGenres() {
    }
    
    @java.lang.Override()
    public void openMovieDetails(int movieId) {
    }
    
    @java.lang.Override()
    public void loadMoviesWithGenre(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> genreIds) {
    }
    
    @java.lang.Override()
    public void onFavoriteClickedListener(@org.jetbrains.annotations.NotNull()
    com.sheyla.projeto_integrador.domain.Movie movie, boolean isChecked) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @kotlin.jvm.JvmStatic()
    public static final com.sheyla.projeto_integrador.presentation.searchmovies.SearchMoviesFragment newInstance(@org.jetbrains.annotations.NotNull()
    java.lang.String movieSearched) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/sheyla/projeto_integrador/presentation/searchmovies/SearchMoviesFragment$Companion;", "", "()V", "ARG_PARAM1", "", "newInstance", "Lcom/sheyla/projeto_integrador/presentation/searchmovies/SearchMoviesFragment;", "movieSearched", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @kotlin.jvm.JvmStatic()
        public final com.sheyla.projeto_integrador.presentation.searchmovies.SearchMoviesFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String movieSearched) {
            return null;
        }
    }
}