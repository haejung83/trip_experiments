package kr.tripstore.proto.shared.data.themecalendar

import kr.tripstore.proto.shared.di.RemoteTripDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThemeCalendarRepository @Inject constructor(
    @RemoteTripDataSource private val remoteDataSource: ThemeCalendarDataSource
) : ThemeCalendarDataSource by remoteDataSource