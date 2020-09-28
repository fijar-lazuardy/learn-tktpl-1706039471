package id.ac.ui.cs.mobileprogramming.fijar.tktpl.lab_2

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.MainActivity
import id.ac.ui.cs.mobileprogramming.fijar.tktpl.R
import kotlinx.android.synthetic.main.activity_degree_converter.view.*
import org.hamcrest.core.StringContains.containsString
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DegreeConverterInstrumentedTest {
    private var degreeToBeConverted: Double = 0.0
    private lateinit var finalDegree: String
    private lateinit var textOnScreen: String

    @get:Rule
    val activityRule: ActivityScenarioRule<DegreeConverterActivity>
        = ActivityScenarioRule(DegreeConverterActivity::class.java)

    @Before
    fun initDegree() {
        degreeToBeConverted = 0.0
        finalDegree = "32\u00B0F"
        textOnScreen = "Input the celsius degree here"
    }

    @Test
    fun checkAllPlaceHolder() {
        onView(withId(R.id.input_celsius_order))
            .check(matches(withText(textOnScreen)))
    }

    @Test
    fun convertDegreeInActivity() {
        onView(withId(R.id.degreeInput))
            .perform(typeText(degreeToBeConverted.toString()), closeSoftKeyboard())

        onView(withId(R.id.degree_convert_button)).perform(click())

        onView(withId(R.id.converted_degree))
            .check(matches(withText(finalDegree)))
    }
}