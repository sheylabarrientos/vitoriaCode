package com.sheyla.projeto_integrador.presentation.adpater;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/sheyla/projeto_integrador/presentation/adpater/CastRvAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/sheyla/projeto_integrador/presentation/adpater/CastRvAdapter$RecyclerviewViewHolder;", "context", "Landroid/content/Context;", "dataset", "", "Lcom/sheyla/projeto_integrador/domain/Cast;", "(Landroid/content/Context;Ljava/util/List;)V", "getContext", "()Landroid/content/Context;", "getDataset", "()Ljava/util/List;", "setDataset", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "RecyclerviewViewHolder", "app_debug"})
public final class CastRvAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.sheyla.projeto_integrador.presentation.adpater.CastRvAdapter.RecyclerviewViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.sheyla.projeto_integrador.domain.Cast> dataset;
    
    public CastRvAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.util.List<com.sheyla.projeto_integrador.domain.Cast> dataset) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.sheyla.projeto_integrador.domain.Cast> getDataset() {
        return null;
    }
    
    public final void setDataset(@org.jetbrains.annotations.NotNull()
    java.util.List<com.sheyla.projeto_integrador.domain.Cast> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.sheyla.projeto_integrador.presentation.adpater.CastRvAdapter.RecyclerviewViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.sheyla.projeto_integrador.presentation.adpater.CastRvAdapter.RecyclerviewViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\"\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/sheyla/projeto_integrador/presentation/adpater/CastRvAdapter$RecyclerviewViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "characterName", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getCharacterName", "()Landroid/widget/TextView;", "setCharacterName", "(Landroid/widget/TextView;)V", "picture", "Landroid/widget/ImageView;", "getPicture", "()Landroid/widget/ImageView;", "setPicture", "(Landroid/widget/ImageView;)V", "role", "getRole", "setRole", "app_debug"})
    public static final class RecyclerviewViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private android.widget.ImageView picture;
        private android.widget.TextView characterName;
        private android.widget.TextView role;
        
        public RecyclerviewViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        public final android.widget.ImageView getPicture() {
            return null;
        }
        
        public final void setPicture(android.widget.ImageView p0) {
        }
        
        public final android.widget.TextView getCharacterName() {
            return null;
        }
        
        public final void setCharacterName(android.widget.TextView p0) {
        }
        
        public final android.widget.TextView getRole() {
            return null;
        }
        
        public final void setRole(android.widget.TextView p0) {
        }
    }
}