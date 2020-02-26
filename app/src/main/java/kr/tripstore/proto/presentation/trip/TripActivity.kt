package kr.tripstore.proto.presentation.trip

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_trip.*
import kr.tripstore.proto.R
import timber.log.Timber

class TripActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip)

        setupBottomNavigationWithNavController()
    }

    private fun setupBottomNavigationWithNavController() {
//        val navController = findNavController(R.id.navhostfragment_trip)
//        bottomappbar_trip.setupWithNavController(navController)

        bottomappbar_trip.apply {
            setOnMenuItemClickListener {
                Timber.d("setOnMenuItemClickListener: $it")
                true
            }
            setNavigationOnClickListener {
                Timber.d("setNavigationOnClickListener: $it")
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navhostfragment_trip).navigateUp()
    }

}
