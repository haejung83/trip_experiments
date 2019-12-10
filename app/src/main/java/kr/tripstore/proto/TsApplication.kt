package kr.tripstore.proto

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import kr.tripstore.proto.di.DaggerAppComponent
import timber.log.Timber

class TsApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        setupTimber()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG)
            Timber.plant(Timber.DebugTree())
    }

}