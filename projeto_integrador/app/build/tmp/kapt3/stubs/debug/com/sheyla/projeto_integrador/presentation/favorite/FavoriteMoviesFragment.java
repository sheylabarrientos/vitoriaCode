package com.sheyla.projeto_integrador.presentation.favorite;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\b\u0010\u0015\u001a\u00020\u0010H\u0002J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u001a\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010&\u001a\u00020\u00102\u0006\u0010\'\u001a\u00020\u0013H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/sheyla/projeto_integrador/presentation/favorite/FavoriteMoviesFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/sheyla/projeto_integrador/presentation/MovieListener;", "()V", "genresAdapter", "Lcom/sheyla/projeto_integrador/presentation/adpater/GenresRvAdapter;", "moviesAdapter", "Lcom/sheyla/projeto_integrador/presentation/adpater/MoviesRvAdapter;", "progressBar", "Landroid/widget/ProgressBar;", "rvGenres", "Landroidx/recyclerview/widget/RecyclerView;", "rvMovies", "viewModelFavorites", "Lcom/sheyla/projeto_integrador/presentation/model/MoviesViewModel;", "loadMoviesWithGenre", "", "genreIds", "", "", "observeFavoriteMovies", "observeGenres", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFavoriteClickedListener", "movie", "Lcom/sheyla/projeto_integrador/domain/Movie;", "isChecked", "", "onResume", "onViewCreated", "view", "openMovieDetails", "movieId", "app_debug"})
public final class FavoriteMoviesFragment extends androidx.fragment.app.Fragment implements com.sheyla.projeto_integrador.presentation.MovieListener {
    private com.sheyla.projeto_integrador.presentation.adpater.MoviesRvAdapter moviesAdapter;
    private android.widget.ProgressBar progressBar;
    private com.sheyla.projeto_integrador.presentation.adpater.GenresRvAdapter genresAdapter;
    private androidx.recyclerview.widget.RecyclerView rvGenres;
    private androidx.recyclerview.widget.RecyclerView rvMovies;
    private com.sheyla.projeto_integrador.presentation.model.MoviesViewModel viewModelFavorites;
    private java.util.HashMap _$_findViewCache;
    
    public FavoriteMoviesFragment() {
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
    
    private final void observeGenres() {
    }
    
    private final void observeFavoriteMovies() {
    }
    
    @java.lang.Override()
    public void onFavoriteClickedListener(@org.jetbrains.annotations.NotNull()
    com.sheyla.projeto_integrador.domain.Movie movie, boolean isChecked) {
    }
    
    @java.lang.Override()
    public void openMovieDetails(int movieId) {
    }
    
    @java.lang.Override()
    public void loadMoviesWithGenre(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> genreIds) {
    }
}