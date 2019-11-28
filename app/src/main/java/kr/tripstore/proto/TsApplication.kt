package kr.tripstore.proto

import android.app.Application
import kr.tripstore.proto.shared.data.source.TripRepository
import timber.log.Timber

class TsApplication : Application() {

    val tripRepository: TripRepository by lazy {
        TripRepository()
    }

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }

}