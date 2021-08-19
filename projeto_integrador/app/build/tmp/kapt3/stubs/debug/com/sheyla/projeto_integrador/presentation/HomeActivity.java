package com.sheyla.projeto_integrador.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/sheyla/projeto_integrador/presentation/HomeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "backToHomeBtn", "Landroid/widget/TextView;", "fragmentContainer", "Landroid/widget/FrameLayout;", "greenIcon", "Landroid/widget/ImageView;", "movieSearched", "", "searchBtn", "Landroid/widget/ImageButton;", "searchEdtTxt", "Landroid/widget/EditText;", "searchFragment", "Lcom/sheyla/projeto_integrador/presentation/searchmovies/SearchMoviesFragment;", "searchModeTxt", "tbLytOptions", "Lcom/google/android/material/tabs/TabLayout;", "viewPager", "Landroidx/viewpager2/widget/ViewPager2;", "bindViews", "", "getTabTitle", "position", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "visibilityNotSearchMode", "visibilitySearchMode", "app_debug"})
public final class HomeActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.EditText searchEdtTxt;
    private android.widget.ImageButton searchBtn;
    private android.widget.ImageView greenIcon;
    private android.widget.TextView searchModeTxt;
    private android.widget.TextView backToHomeBtn;
    private com.google.android.material.tabs.TabLayout tbLytOptions;
    private androidx.viewpager2.widget.ViewPager2 viewPager;
    private android.widget.FrameLayout fragmentContainer;
    private java.lang.String movieSearched;
    private com.sheyla.projeto_integrador.presentation.searchmovies.SearchMoviesFragment searchFragment;
    private java.util.HashMap _$_findViewCache;
    
    public HomeActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void bindViews() {
    }
    
    private final java.lang.String getTabTitle(int position) {
        return null;
    }
    
    private final void visibilitySearchMode() {
    }
    
    private final void visibilityNotSearchMode() {
    }
}