package kr.tripstore.proto.tests.presentation

import android.content.Intent
import androidx.test.rule.ActivityTestRule
import kr.tripstore.proto.R
import kr.tripstore.proto.presentation.trip.TripActivity

class TripActivityTestRule(
    private val initialNavigationId: Int = R.id.nav_trip_fragment
) : ActivityTestRule<TripActivity>(TripActivity::class.java) {

    override fun getActivityIntent(): Intent =
        Intent(Intent.ACTION_MAIN).apply {
            putExtra(TripActivity.EXTRA_NAVIGATION_ID, initialNavigationId)
        }

}