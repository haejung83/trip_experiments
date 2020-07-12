package kr.tripstore.proto.presentation.trip

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_trip.*
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.ActivityTripBinding

@AndroidEntryPoint
class TripActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityTripBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)
            setupBottomNavigationWithNavController()
            setupActivityBySavedInstanceState(savedInstanceState)
        }
    }

    private fun setupActivityBySavedInstanceState(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            if (intent.hasExtra(EXTRA_NAVIGATION_ID)) {
                val initialNavigationId =
                    intent.getIntExtra(EXTRA_NAVIGATION_ID, R.id.nav_trip_fragment)
                val navController = findNavController(R.id.navhostfragment_trip)
                navController.navigate(initialNavigationId)
            }
        }
        // TODO: If you initialize this activity with savedInstanceState. Add else section here
    }

    private fun setupBottomNavigationWithNavController() {
        val navController = findNavController(R.id.navhostfragment_trip)
        bottomnavigationview_trip.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navhostfragment_trip).navigateUp()
    }

    companion object {
        const val EXTRA_NAVIGATION_ID = "extra_navigation_id"
    }

}
