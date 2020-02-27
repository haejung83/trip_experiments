package kr.tripstore.proto.presentation.trip

import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_trip.*
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.ActivityTripBinding

class TripActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityTripBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)
            setupBottomNavigationWithNavController()
        }
    }

    private fun setupBottomNavigationWithNavController() {
        val navController = findNavController(R.id.navhostfragment_trip)
        bottomnavigationview_trip.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navhostfragment_trip).navigateUp()
    }

}
