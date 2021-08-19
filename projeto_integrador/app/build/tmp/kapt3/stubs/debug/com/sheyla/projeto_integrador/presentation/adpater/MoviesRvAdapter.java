package com.sheyla.projeto_integrador.presentation.adpater;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/sheyla/projeto_integrador/presentation/adpater/MoviesRvAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sheyla/projeto_integrador/presentation/adpater/MoviesRvAdapter$ViewHolder;", "context", "Landroid/content/Context;", "listener", "Lcom/sheyla/projeto_integrador/presentation/MovieListener;", "dataSet", "", "Lcom/sheyla/projeto_integrador/domain/Movie;", "(Landroid/content/Context;Lcom/sheyla/projeto_integrador/presentation/MovieListener;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getDataSet", "()Ljava/util/List;", "setDataSet", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class MoviesRvAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.sheyla.projeto_integrador.presentation.adpater.MoviesRvAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final com.sheyla.projeto_integrador.presentation.MovieListener listener = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.sheyla.projeto_integrador.domain.Movie> dataSet;
    
    public MoviesRvAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    com.sheyla.projeto_integrador.presentation.MovieListener listener, @org.jetbrains.annotations.NotNull()
    java.util.List<com.sheyla.projeto_integrador.domain.Movie> dataSet) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.sheyla.projeto_integrador.domain.Movie> getDataSet() {
        return null;
    }
    
    public final void setDataSet(@org.jetbrains.annotations.NotNull()
    java.util.List<com.sheyla.projeto_integrador.domain.Movie> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.sheyla.projeto_integrador.presentation.adpater.MoviesRvAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.sheyla.projeto_integrador.presentation.adpater.MoviesRvAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/sheyla/projeto_integrador/presentation/adpater/MoviesRvAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "favBtn", "Landroid/widget/ToggleButton;", "getFavBtn", "()Landroid/widget/ToggleButton;", "setFavBtn", "(Landroid/widget/ToggleButton;)V", "imageMovie", "Landroid/widget/ImageView;", "getImageMovie", "()Landroid/widget/ImageView;", "setImageMovie", "(Landroid/widget/ImageView;)V", "movieId", "Landroid/widget/TextView;", "getMovieId", "()Landroid/widget/TextView;", "setMovieId", "(Landroid/widget/TextView;)V", "movieTitle", "getMovieTitle", "setMovieTitle", "rating", "getRating", "setRating", "app_debug"})
    public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.Nullable()
        private android.widget.ImageView imageMovie;
        @org.jetbrains.annotations.Nullable()
        private android.widget.TextView movieTitle;
        @org.jetbrains.annotations.Nullable()
        private android.widget.TextView rating;
        @org.jetbrains.annotations.Nullable()
        private android.widget.ToggleButton favBtn;
        @org.jetbrains.annotations.Nullable()
        private android.widget.TextView movieId;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.ImageView getImageMovie() {
            return null;
        }
        
        public final void setImageMovie(@org.jetbrains.annotations.Nullable()
        android.widget.ImageView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getMovieTitle() {
            return null;
        }
        
        public final void setMovieTitle(@org.jetbrains.annotations.Nullable()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getRating() {
            return null;
        }
        
        public final void setRating(@org.jetbrains.annotations.Nullable()
        android.widget.TextView p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.ToggleButton getFavBtn() {
            return null;
        }
        
        public final void setFavBtn(@org.jetbrains.annotations.Nullable()
        android.widget.ToggleButton p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView getMovieId() {
            return null;
        }
        
        public final void setMovieId(@org.jetbrains.annotations.Nullable()
        android.widget.TextView p0) {
        }
    }
}