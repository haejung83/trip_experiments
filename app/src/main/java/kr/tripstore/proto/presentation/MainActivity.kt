package kr.tripstore.proto.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kr.tripstore.proto.R
import kr.tripstore.proto.extension.moveToActivity
import kr.tripstore.proto.presentation.trip.TripActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_trip.setOnClickListener { moveToActivity(TripActivity::class.java) }
    }
}
