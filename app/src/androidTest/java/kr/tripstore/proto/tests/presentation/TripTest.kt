package kr.tripstore.proto.tests.presentation

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kr.tripstore.proto.R
import kr.tripstore.proto.shared.di.CoroutineModule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@UninstallModules(CoroutineModule::class)
@RunWith(AndroidJUnit4::class)
class TripTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = TripActivityTestRule(R.id.nav_trip_fragment)

    @Test
    fun trip_anyTripThemeItemDisplayed() {
        // Super Simple Testing
        onView(withId(R.id.recyclerview_trip)).check(matches(isDisplayed()))
    }

}