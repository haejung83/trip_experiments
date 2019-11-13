package kr.tripstore.proto.presentation.trip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_trip.*
import kr.tripstore.proto.R

class TripActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip)

        setupBottomNavigationWithNavController()
    }

    private fun setupBottomNavigationWithNavController() {
        val navController = findNavController(R.id.navhostfragment_trip)
        bottomnavigationview_trip.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navhostfragment_trip).navigateUp()
    }

}
