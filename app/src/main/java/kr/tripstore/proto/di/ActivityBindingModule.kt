package kr.tripstore.proto.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kr.tripstore.proto.presentation.trip.TripActivity
import kr.tripstore.proto.presentation.trip.TripModule
import kr.tripstore.proto.shared.di.ActivityScope

@Module
@Suppress("UNUSED")
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            TripModule::class
        ]
    )
    internal abstract fun tripActivity(): TripActivity

}