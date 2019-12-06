package kr.tripstore.proto

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import kr.tripstore.proto.di.DaggerAppComponent
import kr.tripstore.proto.shared.data.source.TripRepository
import kr.tripstore.proto.shared.data.source.remote.TripRemoteDataSource
import timber.log.Timber

class TsApplication : DaggerApplication() {

    val tripRepository: TripRepository by lazy {
        TripRepository(TripRemoteDataSource())
    }

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