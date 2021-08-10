package com.sheyla.projeto_integrador

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sheyla.projeto_integrador.domain.Tools

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.sheyla.projeto_integrador", appContext.packageName)
    }

    @Test
    fun testIds() {
        val searchTextIdExpected:Int = R.id.search_movie
        assertEquals(searchTextIdExpected,Tools.searchID)
    }

    @Test
    fun testTimeConversion() {
        val expectedString:String = "8h 20min"
        val obtainedString:String = Tools.timeConversion(500)

        assertEquals(expectedString, obtainedString)
    }

    @Test
    fun testRatingConversion() {
        val expectedString:String = "85%"
        val obtainedString:String = Tools.ratingConversion(8.5F)

        assertEquals(expectedString, obtainedString)
    }
}