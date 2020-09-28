package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_2

import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test

class DegreeActivityUnitTest {
    private val model = DegreeModel()

    @Test
    fun testConvertCelsiusToFahrenheit() {
        val convertedDegree = model.convertDegree(0.0)
        assertEquals(convertedDegree, 32.0, 0.2)
    }

    @Test
    fun testDegreeDisplayedOnUI() {
        val convertedDegree = model.degreeToDisplayOnUI("0")
        assertEquals(convertedDegree, "32\u00B0F")
    }
}