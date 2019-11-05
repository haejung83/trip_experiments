package kr.tripstore.proto

import android.app.Application
import timber.log.Timber

class TsApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }

}