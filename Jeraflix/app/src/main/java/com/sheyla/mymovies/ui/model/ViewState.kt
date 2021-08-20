package com.sheyla.mymovies.ui.model

sealed class ViewState {
    object MovieNotFound: ViewState()
    object GeneralError: ViewState()
}
