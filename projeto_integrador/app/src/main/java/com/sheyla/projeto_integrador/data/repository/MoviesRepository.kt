package com.sheyla.projeto_integrador.data.repository

import com.sheyla.projeto_integrador.data.modelresponse.*
import io.reactivex.Observable

class MoviesRepository {
    fun fetchList() : Observable<MovieResponse> {
        return Network.getService().getMovies() //Essa função chama o arquivo de serviços e o retrofit.
    }

    fun fetchDetailsList(movieId : Int) : Observable<ReleaseDatesResponse> {
        return Network.getService().getReleaseDate(movieId) //Essa função chama o arquivo de serviços e o retrofit, montando a chamada que trás as informações dos detalhes filmes (imagem, título, rating, sinopse, ano, certificação e duração).
    }

    fun fetchCast(movieId2 : Int) : Observable<ListCast> {
        return Network.getService().getCast(movieId2) //Essa função chama o arquivo de serviços e o retrofit, montando a chamada que trás as informações dos detalhes do "cast" (imagem, nome e papel).
    }

    fun fetchAllGenres() : Observable<ListAllMoviesGenres> {
        return Network.getService().getAllMoviesGenres() //Essa função chama o arquivo de serviços e o retrofit, montando a chamada que trás as informações dos gêneros dos filmes.
    }

    fun fetchGenres(movieId3 : Int) : Observable<ListAllMoviesGenres> {
        return Network.getService().getGenres(movieId3) //Essa função chama o arquivo de serviços e o retrofit, montando a chamada que trás as informações dos gêneros de cada filme.
    }

    fun fetchSelectGenres(movieId4 : String) : Observable<Movie> {
        return Network.getService().getSelectGenres(movieId4) //Essa função chama o arquivo de serviços e o retrofit, montando a chamada que trás as informações para que o "chip button" consiga selecionar os filmes por gênero.
    }

    fun fetchRuntime(movieId5 : Int) : Observable<Runtime> {
        return Network.getService().getRuntime(movieId5) //Essa função chama o arquivo de serviços e o retrofit, montando a chamada que trás as informações de "runtime" dos detalhes dos filmes.
    }
}