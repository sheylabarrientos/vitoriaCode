package com.sheyla.projeto_integrador.data.repository

import com.sheyla.projeto_integrador.data.model.Movies

class MoviesRepository {
    fun fetchList() : io.reactivex.Observable<Movies> {
        return NetworkRetrofit.getService().getMovies() //Essa função chama o arquivo de serviços e o retrofit.
    }
}