package com.sheyla.projeto_integrador.presentation

import com.sheyla.projeto_integrador.data.repository.MoviesRepository

class FetchDetailsUseCase(private val repository: MoviesRepository = MoviesRepository(), private val movieId: Int)
{
    fun execute() = repository.fetchDetailsList(movieId)
}

class FetchCastUseCase(private val repository: MoviesRepository = MoviesRepository(), private val movieId2: Int)
{
    fun execute() = repository.fetchCast(movieId2)
}

class FetchAllGenresUseCase(private val repository: MoviesRepository = MoviesRepository())
{
    fun execute() = repository.fetchAllGenres()
}

class FetchGenresUseCase(private val repository: MoviesRepository = MoviesRepository(), private val movieId3: Int)
{
    fun execute() = repository.fetchGenres(movieId3)
}

class FetchSelectGenresUseCase(private val repository: MoviesRepository = MoviesRepository(), private val movieId4 : List<Int>) //O "movieId4" foi setado como lista pois a chamada trará uma lista de "ids".
{
    fun execute() = repository.fetchSelectGenres(movieId4.joinToString(",")) //O separador "," foi necessário pois é uma obrigatoriedade determinada pela documentação para uso da "@Query" relativa ao "with_genres" (https://developers.themoviedb.org/3/discover/movie-discover).
}

class FetchRuntimeUseCase(private val repository: MoviesRepository = MoviesRepository(), private val movieId5 : Int)
{
    fun execute() = repository.fetchRuntime(movieId5)
}