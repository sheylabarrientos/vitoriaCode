package com.sheyla.projeto_integrador.data.model

import com.sheyla.projeto_integrador.data.repository.MoviesRepository

class FetchMoviesUseCase (private val repository: MoviesRepository = MoviesRepository())
{
    fun execute() = repository.fetchList() //Essa função chama a classe do repositório.
}