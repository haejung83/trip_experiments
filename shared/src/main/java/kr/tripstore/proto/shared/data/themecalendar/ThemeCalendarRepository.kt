package kr.tripstore.proto.shared.data.themecalendar

import kr.tripstore.proto.shared.di.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ThemeCalendarRepository @Inject constructor(
    @RemoteDataSource private val remoteDataSource: ThemeCalendarDataSource
) : ThemeCalendarDataSource by remoteDataSource