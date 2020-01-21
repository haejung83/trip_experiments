package kr.tripstore.proto.shared.di

import dagger.Module
import dagger.Provides
import kr.tripstore.proto.shared.data.calendar.CalendarsDataSource
import kr.tripstore.proto.shared.data.calendar.CalendarsRemoteDataSource
import kr.tripstore.proto.shared.data.calendar.CalendarsRepository
import kr.tripstore.proto.shared.data.temperature.TemperaturesDataSource
import kr.tripstore.proto.shared.data.temperature.TemperaturesRemoteDataSource
import kr.tripstore.proto.shared.data.temperature.TemperaturesRepository
import kr.tripstore.proto.shared.data.trip.TripDataSource
import kr.tripstore.proto.shared.data.trip.TripRemoteDataSource
import kr.tripstore.proto.shared.data.trip.TripRepository
import javax.inject.Singleton

@Module
class SharedModule {

    /*
     * TripDataSource
     */
    @Provides
    @RemoteTripDataSource
    fun provideTripDataSource(): TripDataSource =
        TripRemoteDataSource()


    @Singleton
    @Provides
    fun provideTripRepository(
        @RemoteTripDataSource remoteTripDataSource: TripDataSource
    ): TripRepository =
        TripRepository(remoteTripDataSource)

    /*
     * CalendarsDataSource
     */
    @Provides
    @RemoteTripDataSource
    fun provideCalendarsDataSource(): CalendarsDataSource =
        CalendarsRemoteDataSource()

    @Singleton
    @Provides
    fun provideCalendarsRepository(
        @RemoteTripDataSource remoteCalendarsDataSource: CalendarsDataSource
    ) = CalendarsRepository(remoteCalendarsDataSource)

    /*
     * TemperaturesDataSource
     */
    @Provides
    @RemoteTripDataSource
    fun provideTemperaturesDataSource(): TemperaturesDataSource =
        TemperaturesRemoteDataSource()

    @Singleton
    @Provides
    fun provideTemperaturesRepository(
        @RemoteTripDataSource remoteTemperaturesDataSource: TemperaturesDataSource
    ) = TemperaturesRepository(remoteTemperaturesDataSource)

}