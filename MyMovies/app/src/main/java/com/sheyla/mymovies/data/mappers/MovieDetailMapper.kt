package com.sheyla.mymovies.mappers

import com.sheyla.mymovies.data.model.movies.MovieDetailResponse
import com.sheyla.mymovies.domain.MovieDetail

class MovieDetailMapper {
    fun map(movieResponse: MovieDetailResponse): MovieDetail {
        val movieDetailed = MovieDetail(
            backdrop_path = movieResponse.backdrop_path,
            genres = movieResponse.genres,
            id = movieResponse.id,
            overview = movieResponse.overview,
            release_date = movieResponse.release_date,
            runtime = movieResponse.runtime,
            vote_average = movieResponse.vote_average,
            title = movieResponse.title,
            isFavorite = movieResponse.isFavorite
        )
        return movieDetailed
    }
}