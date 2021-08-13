package com.sheyla.projeto_integrador

import com.sheyla.projeto_integrador.domain.Genre
import com.sheyla.projeto_integrador.domain.MovieDetail
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieDetailsTest {
    @Test
    fun testIds() {
        val searchTextIdExpected:Int = R.id.searchMovie
        assertEquals(searchTextIdExpected, MovieDetail.searchID)
    }

    @Test
    fun testTimeConversion() {
        val expectedString:String = "8h 20min"
        val obtainedString:String = MovieDetail.timeConversion(500)

        assertEquals(expectedString, obtainedString)
    }

    @Test
    fun testRatingConversion() {
        val expectedString:String = "85%"
        val obtainedString:String = MovieDetail.ratingConversion(8.5F)

        assertEquals(expectedString, obtainedString)
    }
}