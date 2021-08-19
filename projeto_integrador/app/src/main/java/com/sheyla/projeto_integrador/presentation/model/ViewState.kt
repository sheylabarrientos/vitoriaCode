package com.sheyla.projeto_integrador.presentation.model

sealed class ViewState {
    object MovieNotFound: ViewState()
    object GeneralError: ViewState()
}
