package kr.tripstore.proto.shared.di

import dagger.Module
import dagger.Provides
import kr.tripstore.proto.shared.data.agency.*
import kr.tripstore.proto.shared.data.airline.AirlineDataSource
import kr.tripstore.proto.shared.data.airline.AirlineRemoteDataSource
import kr.tripstore.proto.shared.data.airline.AirlineRepository
import kr.tripstore.proto.shared.data.calendar.CalendarsDataSource
import kr.tripstore.proto.shared.data.calendar.CalendarsRemoteDataSource
import kr.tripstore.proto.shared.data.calendar.CalendarsRepository
import kr.tripstore.proto.shared.data.departurecity.DepartureCityDataSource
import kr.tripstore.proto.shared.data.departurecity.DepartureCityRemoteDataSource
import kr.tripstore.proto.shared.data.departurecity.DepartureCityRepository
import kr.tripstore.proto.shared.data.temperature.TemperaturesDataSource
import kr.tripstore.proto.shared.data.temperature.TemperaturesRemoteDataSource
import kr.tripstore.proto.shared.data.temperature.TemperaturesRepository
import kr.tripstore.proto.shared.data.themecalendar.ThemeCalendarDataSource
import kr.tripstore.proto.shared.data.themecalendar.ThemeCalendarRemoteDataSource
import kr.tripstore.proto.shared.data.themecalendar.ThemeCalendarRepository
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
    @RemoteDataSource
    fun provideTripDataSource(): TripDataSource =
        TripRemoteDataSource()

    @Singleton
    @Provides
    fun provideTripRepository(
        @RemoteDataSource remoteTripDataSource: TripDataSource
    ): TripRepository =
        TripRepository(remoteTripDataSource)

    /*
     * CalendarsDataSource
     */
    @Provides
    @RemoteDataSource
    fun provideCalendarsDataSource(): CalendarsDataSource =
        CalendarsRemoteDataSource()

    @Singleton
    @Provides
    fun provideCalendarsRepository(
        @RemoteDataSource remoteCalendarsDataSource: CalendarsDataSource
    ) = CalendarsRepository(remoteCalendarsDataSource)

    /*
     * TemperaturesDataSource
     */
    @Provides
    @RemoteDataSource
    fun provideTemperaturesDataSource(): TemperaturesDataSource =
        TemperaturesRemoteDataSource()

    @Singleton
    @Provides
    fun provideTemperaturesRepository(
        @RemoteDataSource remoteTemperaturesDataSource: TemperaturesDataSource
    ) = TemperaturesRepository(remoteTemperaturesDataSource)

    /*
     * ThemeCalendarDataSource
     */
    @Provides
    @RemoteDataSource
    fun provideThemeCalendarDataSource(): ThemeCalendarDataSource =
        ThemeCalendarRemoteDataSource()

    @Singleton
    @Provides
    fun provideThemeCalendarRepository(
        @RemoteDataSource remoteThemeCalendarDataSource: ThemeCalendarDataSource
    ) = ThemeCalendarRepository(remoteThemeCalendarDataSource)

    /*
     * AgencyDataSource
     */
    @Provides
    @RemoteDataSource
    fun provideAgencyRemoteDataSource(): AgencyDataSource =
        AgencyRemoteDataSource()

    @Provides
    @LocalDataSource
    fun provideAgencyLocalDataSource(): AgencyCacheDataSource =
        AgencyLocalDataSource()

    @Singleton
    @Provides
    fun provideAgencyRepository(
        @RemoteDataSource remoteAgencyDataSource: AgencyDataSource,
        @LocalDataSource localAgencyCacheDataSource: AgencyCacheDataSource
    ) = AgencyRepository(remoteAgencyDataSource, localAgencyCacheDataSource)

    /*
     * AirlineDataSource
     */
    @Provides
    @RemoteDataSource
    fun provideAirlineRemoteDataSource(): AirlineDataSource =
        AirlineRemoteDataSource()

    @Singleton
    @Provides
    fun provideAirlineRepository(
        @RemoteDataSource remoteAirlineDataSource: AirlineDataSource
    ) = AirlineRepository(remoteAirlineDataSource)

    /*
     * DepartureCityDataSource
     */
    @Provides
    @RemoteDataSource
    fun provideDepartureCityRemoteDataSource(): DepartureCityDataSource =
        DepartureCityRemoteDataSource()

    @Singleton
    @Provides
    fun provideDepartureCityRepository(
        @RemoteDataSource remoteDepartureCityDataSource: DepartureCityDataSource
    ) = DepartureCityRepository(remoteDepartureCityDataSource)

}