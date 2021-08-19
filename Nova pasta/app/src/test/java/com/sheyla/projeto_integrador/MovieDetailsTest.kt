package com.sheyla.projeto_integrador

import com.sheyla.projeto_integrador.domain.Genre
import com.sheyla.projeto_integrador.domain.MovieDetail
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieDetailsTest {
    @Test
    fun `show the hours apart from minutes of movie`() {
        val genreList = mutableListOf<Genre>()
        val movieDetailed = MovieDetail(
            "",
            genres = genreList,
            3,
            "",
            "2001-09-13",
            113,
            8f,
            "Moana",
        )
        val expectedResult = "1h 53min"

        val result = movieDetailed.getRuntime()

        assertEquals(expectedResult, result)
    }

    @Test
    fun `show percent likes as a 0-100`() {

        val genreList = mutableListOf<Genre>()
        val movieDetailed = MovieDetail(
            "",
            genres = genreList,
            1,
            "",
            "2001-09-13",
            null,
            8f,
            "Barbie",
        )
        val expectedResult = "80%"

        val result = movieDetailed.getRating()

        assertEquals(expectedResult, result)
    }

    @Test
    fun `show the year that movie was released`() {

        val genreList = mutableListOf<Genre>()
        val movieDetailed = MovieDetail(
            "",
            genres = genreList,
            2,
            "",
            "2001-09-13",
            null,
            8f,
            "Lilo & Stitch",
        )
        val expectedResult = "2001"

        val result = movieDetailed.getReleaseYear()

        assertEquals(expectedResult, result)
    }

}