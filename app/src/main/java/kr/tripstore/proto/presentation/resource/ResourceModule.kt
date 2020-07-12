package kr.tripstore.proto.presentation.resource

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@InstallIn(ApplicationComponent::class)
@Module
class ResourceModule {

    /**
     * DayOfWeek String Resource Provider
     */
    @Provides
    fun provideDayOfWeekProvider(@ApplicationContext context: Context): DayOfWeekStringProvider =
        ContextDayOfWeekStringProvider(context)

    /**
     * TripLink Symbol String Provider
     */
    @Provides
    fun provideTripLinkSymbolProvider(@ApplicationContext context: Context): TripLinkSymbolStringProvider =
        ContextTripLinkSymbolStringProvider(context)

}