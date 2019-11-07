package kr.tripstore.proto.presentation.trip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.trip_activity.*
import kr.tripstore.proto.R
import kr.tripstore.proto.extension.replaceFragmentInActivity

class TripActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trip_activity)

        setupBottomNavigationWithNavController()
    }

    private fun setupBottomNavigationWithNavController() {
        val navController = findNavController(R.id.nav_host_fragment)
        bottom_navigation_view.setupWithNavController(navController)
    }

}
