package com.sheyla.projeto_integrador.presentation.allmovies;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\rH\u0002J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\u001a\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/sheyla/projeto_integrador/presentation/allmovies/AllMoviesFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/sheyla/projeto_integrador/presentation/MovieListener;", "()V", "genresAdapter", "Lcom/sheyla/projeto_integrador/presentation/adpater/GenresRvAdapter;", "listAdapter", "Lcom/sheyla/projeto_integrador/presentation/adpater/MoviesRvAdapter;", "moviesViewModel", "Lcom/sheyla/projeto_integrador/presentation/model/MoviesViewModel;", "progressBar", "Landroid/widget/ProgressBar;", "loadMoviesWithGenre", "", "genreIds", "", "", "observeGenres", "observeListMovies", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFavoriteClickedListener", "movie", "Lcom/sheyla/projeto_integrador/domain/Movie;", "isChecked", "", "onResume", "onViewCreated", "view", "openMovieDetails", "movieId", "app_debug"})
public final class AllMoviesFragment extends androidx.fragment.app.Fragment implements com.sheyla.projeto_integrador.presentation.MovieListener {
    private com.sheyla.projeto_integrador.presentation.adpater.MoviesRvAdapter listAdapter;
    private com.sheyla.projeto_integrador.presentation.adpater.GenresRvAdapter genresAdapter;
    private android.widget.ProgressBar progressBar;
    private com.sheyla.projeto_integrador.presentation.model.MoviesViewModel moviesViewModel;
    private java.util.HashMap _$_findViewCache;
    
    public AllMoviesFragment() {
        super();
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
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void observeListMovies() {
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
}