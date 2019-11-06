package kr.tripstore.proto.presentation.trip

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kr.tripstore.proto.R
import kr.tripstore.proto.extension.replaceFragmentInActivity

class TripActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trip_activity)
        if (savedInstanceState == null) {
            replaceFragmentInActivity(TripFragment.newInstance(), R.id.container)
        }
    }

}
