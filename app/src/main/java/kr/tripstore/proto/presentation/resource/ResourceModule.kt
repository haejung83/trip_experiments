package kr.tripstore.proto.presentation.resource

import android.content.Context
import dagger.Module
import dagger.Provides
import kr.tripstore.proto.shared.di.ActivityScope

@Module
class ResourceModule {

    /**
     * DayOfWeek String Resource Provider
     */
    @ActivityScope
    @Provides
    fun provideDayOfWeekProvider(context: Context): DayOfWeekStringProvider =
        ContextDayOfWeekStringProvider(context)

    /**
     * TripLink Symbol String Provider
     */
    @ActivityScope
    @Provides
    fun provideTripLinkSymbolProvider(context: Context): TripLinkSymbolStringProvider =
        ContextTripLinkSymbolStringProvider(context)

}