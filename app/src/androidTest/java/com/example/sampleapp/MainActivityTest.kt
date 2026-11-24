package com.example.sampleapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Test
    fun counterStartsAtZeroAndUsesSingularAfterOneClick() {
        ActivityScenario.launch(MainActivity::class.java).use {
            onView(withId(R.id.countText)).check(matches(withText("Button clicked 0 times")))
            onView(withId(R.id.clickButton)).perform(click())
            onView(withId(R.id.countText)).check(matches(withText("Button clicked 1 time")))
            onView(withId(R.id.clickButton)).perform(click())
            onView(withId(R.id.countText)).check(matches(withText("Button clicked 2 times")))
        }
    }

    @Test
    fun counterSurvivesActivityRecreationAndContinuesCounting() {
        ActivityScenario.launch(MainActivity::class.java).use { scenario ->
            onView(withId(R.id.clickButton)).perform(click(), click())
            scenario.recreate()
            onView(withId(R.id.countText)).check(matches(withText("Button clicked 2 times")))
            onView(withId(R.id.clickButton)).perform(click())
            onView(withId(R.id.countText)).check(matches(withText("Button clicked 3 times")))
        }
    }
}
