package com.sheyla.projeto_integrador.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u00002\u00020\u0001Ba\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\u0006\u0010#\u001a\u00020\u0003J\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010\u001d\u001a\u00020\u0003R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"\u00a8\u0006%"}, d2 = {"Lcom/sheyla/projeto_integrador/domain/MovieDetail;", "", "backdrop_path", "", "genres", "", "Lcom/sheyla/projeto_integrador/domain/Category;", "id", "", "overview", "release_date", "runtime", "vote_average", "", "title", "isFavorite", "", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;FLjava/lang/String;Z)V", "getBackdrop_path", "()Ljava/lang/String;", "getGenres", "()Ljava/util/List;", "getId", "()I", "()Z", "setFavorite", "(Z)V", "getOverview", "getRelease_date", "getRuntime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTitle", "getVote_average", "()F", "getRating", "getReleaseYear", "app_debug"})
public final class MovieDetail {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String backdrop_path = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.sheyla.projeto_integrador.domain.Category> genres = null;
    private final int id = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String overview = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String release_date = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer runtime = null;
    private final float vote_average = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    private boolean isFavorite;
    
    public MovieDetail(@org.jetbrains.annotations.Nullable()
    java.lang.String backdrop_path, @org.jetbrains.annotations.NotNull()
    java.util.List<com.sheyla.projeto_integrador.domain.Category> genres, int id, @org.jetbrains.annotations.Nullable()
    java.lang.String overview, @org.jetbrains.annotations.NotNull()
    java.lang.String release_date, @org.jetbrains.annotations.Nullable()
    java.lang.Integer runtime, float vote_average, @org.jetbrains.annotations.NotNull()
    java.lang.String title, boolean isFavorite) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getBackdrop_path() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.sheyla.projeto_integrador.domain.Category> getGenres() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getOverview() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRelease_date() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRuntime() {
        return null;
    }
    
    public final float getVote_average() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final boolean isFavorite() {
        return false;
    }
    
    public final void setFavorite(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReleaseYear() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRuntime() {
        return null;
    }
}