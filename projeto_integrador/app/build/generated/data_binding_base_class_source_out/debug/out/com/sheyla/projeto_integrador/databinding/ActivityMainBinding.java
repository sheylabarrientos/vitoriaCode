// Generated by view binder compiler. Do not edit!
package com.sheyla.projeto_integrador.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.sheyla.projeto_integrador.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final TextView backToHomeBtn;

  @NonNull
  public final ImageView greenIcon;

  @NonNull
  public final FrameLayout searchFragmentContainer;

  @NonNull
  public final TextView searchModeTxt;

  @NonNull
  public final EditText searchMovie;

  @NonNull
  public final ImageButton submitSearch;

  @NonNull
  public final TabLayout tabLytOptions;

  @NonNull
  public final ViewPager2 viewPager;

  private ActivityMainBinding(@NonNull ScrollView rootView, @NonNull TextView backToHomeBtn,
      @NonNull ImageView greenIcon, @NonNull FrameLayout searchFragmentContainer,
      @NonNull TextView searchModeTxt, @NonNull EditText searchMovie,
      @NonNull ImageButton submitSearch, @NonNull TabLayout tabLytOptions,
      @NonNull ViewPager2 viewPager) {
    this.rootView = rootView;
    this.backToHomeBtn = backToHomeBtn;
    this.greenIcon = greenIcon;
    this.searchFragmentContainer = searchFragmentContainer;
    this.searchModeTxt = searchModeTxt;
    this.searchMovie = searchMovie;
    this.submitSearch = submitSearch;
    this.tabLytOptions = tabLytOptions;
    this.viewPager = viewPager;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.backToHomeBtn;
      TextView backToHomeBtn = rootView.findViewById(id);
      if (backToHomeBtn == null) {
        break missingId;
      }

      id = R.id.greenIcon;
      ImageView greenIcon = rootView.findViewById(id);
      if (greenIcon == null) {
        break missingId;
      }

      id = R.id.searchFragmentContainer;
      FrameLayout searchFragmentContainer = rootView.findViewById(id);
      if (searchFragmentContainer == null) {
        break missingId;
      }

      id = R.id.searchModeTxt;
      TextView searchModeTxt = rootView.findViewById(id);
      if (searchModeTxt == null) {
        break missingId;
      }

      id = R.id.searchMovie;
      EditText searchMovie = rootView.findViewById(id);
      if (searchMovie == null) {
        break missingId;
      }

      id = R.id.submitSearch;
      ImageButton submitSearch = rootView.findViewById(id);
      if (submitSearch == null) {
        break missingId;
      }

      id = R.id.tabLytOptions;
      TabLayout tabLytOptions = rootView.findViewById(id);
      if (tabLytOptions == null) {
        break missingId;
      }

      id = R.id.viewPager;
      ViewPager2 viewPager = rootView.findViewById(id);
      if (viewPager == null) {
        break missingId;
      }

      return new ActivityMainBinding((ScrollView) rootView, backToHomeBtn, greenIcon,
          searchFragmentContainer, searchModeTxt, searchMovie, submitSearch, tabLytOptions,
          viewPager);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
