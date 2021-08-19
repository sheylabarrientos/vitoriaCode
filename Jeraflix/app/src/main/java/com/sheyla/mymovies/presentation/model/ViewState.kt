package com.sheyla.mymovies.presentation.model

sealed class ViewState {
    object MovieNotFound: ViewState()
    object GeneralError: ViewState()
}
