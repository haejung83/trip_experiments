package kr.tripstore.proto.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kr.tripstore.proto.presentation.calendar.CalendarModule
import kr.tripstore.proto.presentation.profile.ProfileModule
import kr.tripstore.proto.presentation.save.SaveModule
import kr.tripstore.proto.presentation.search.SearchModule
import kr.tripstore.proto.presentation.trip.TripActivity
import kr.tripstore.proto.presentation.trip.TripModule
import kr.tripstore.proto.presentation.web.WebModule
import kr.tripstore.proto.shared.di.ActivityScope

@Module
@Suppress("UNUSED")
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            TripModule::class,
            SearchModule::class,
            SaveModule::class,
            ProfileModule::class,
            WebModule::class,
            CalendarModule::class
        ]
    )
    internal abstract fun tripActivity(): TripActivity

}