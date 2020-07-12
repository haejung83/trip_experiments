package kr.tripstore.proto.tests.presentation

import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kr.tripstore.proto.R
import kr.tripstore.proto.shared.di.CoroutineModule
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@UninstallModules(CoroutineModule::class)
@RunWith(AndroidJUnit4::class)
class SearchTest {

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var activityRule = TripActivityTestRule(R.id.nav_search_fragment)

    @Test
    fun search_anyCountDisplayed() {
        onView(
            allOf(
                instanceOf(TextView::class.java),
                withParent(withId(R.id.constraintlayout_search_fragment))
            )
        ).check(matches(withText("30")))
    }

}