package kr.tripstore.proto.shared.data.calendar

import kr.tripstore.proto.shared.di.RemoteTripDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CalendarsRepository @Inject constructor(
    @RemoteTripDataSource private val remoteDataSource: CalendarsDataSource
) : CalendarsDataSource by remoteDataSource