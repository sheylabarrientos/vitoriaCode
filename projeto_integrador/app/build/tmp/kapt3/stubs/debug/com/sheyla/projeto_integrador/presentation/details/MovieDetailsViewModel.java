package com.sheyla.projeto_integrador.presentation.details;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001f\u001a\u00020\u001aH\u0014J\f\u0010 \u001a\u00020!*\u00020!H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010\u00a8\u0006\""}, d2 = {"Lcom/sheyla/projeto_integrador/presentation/details/MovieDetailsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_castLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/sheyla/projeto_integrador/domain/Cast;", "_certificationLiveData", "Lcom/sheyla/projeto_integrador/domain/Certification;", "_favoriteMoviesLiveData", "Lcom/sheyla/projeto_integrador/domain/Movie;", "_movieLiveData", "Lcom/sheyla/projeto_integrador/domain/MovieDetail;", "castLiveData", "Landroidx/lifecycle/LiveData;", "getCastLiveData", "()Landroidx/lifecycle/LiveData;", "certificationLiveData", "getCertificationLiveData", "disposable", "Lio/reactivex/disposables/CompositeDisposable;", "favoriteMoviesLiveData", "getFavoriteMoviesLiveData", "movieLiveData", "getMovieLiveData", "getCast", "", "movieId", "", "getCertification", "getMovieDetails", "onCleared", "handleDisposable", "Lio/reactivex/disposables/Disposable;", "app_debug"})
public final class MovieDetailsViewModel extends androidx.lifecycle.ViewModel {
    private final androidx.lifecycle.MutableLiveData<com.sheyla.projeto_integrador.domain.MovieDetail> _movieLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.sheyla.projeto_integrador.domain.MovieDetail> movieLiveData = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.sheyla.projeto_integrador.domain.Cast>> _castLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Cast>> castLiveData = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.sheyla.projeto_integrador.domain.Certification>> _certificationLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Certification>> certificationLiveData = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> _favoriteMoviesLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> favoriteMoviesLiveData = null;
    private final io.reactivex.disposables.CompositeDisposable disposable = null;
    
    public MovieDetailsViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.sheyla.projeto_integrador.domain.MovieDetail> getMovieLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Cast>> getCastLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Certification>> getCertificationLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.sheyla.projeto_integrador.domain.Movie>> getFavoriteMoviesLiveData() {
        return null;
    }
    
    public final void getMovieDetails(int movieId) {
    }
    
    public final void getCast(int movieId) {
    }
    
    public final void getCertification(int movieId) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    private final io.reactivex.disposables.Disposable handleDisposable(io.reactivex.disposables.Disposable $this$handleDisposable) {
        return null;
    }
}