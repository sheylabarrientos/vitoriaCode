package com.sheyla.projeto_integrador.data.repository

import com.sheyla.projeto_integrador.data.modelresponse.MovieResponse

class MoviesRepository {
    fun fetchList() : io.reactivex.Observable<MovieResponse> {
        return Network.getService().getMovies() //Essa função chama o arquivo de serviços e o retrofit.
    }

    fun fetchCharactersListLocally(){
        //return Network.getDatabase().get
    }
}