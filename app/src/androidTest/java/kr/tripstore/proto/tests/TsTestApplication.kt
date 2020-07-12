package kr.tripstore.proto.tests

import android.app.Application
import timber.log.Timber

open class TsTestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}