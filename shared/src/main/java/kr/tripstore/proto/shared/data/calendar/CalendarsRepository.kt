package kr.tripstore.proto.shared.data.calendar

import kr.tripstore.proto.shared.di.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CalendarsRepository @Inject constructor(
    @RemoteDataSource private val remoteDataSource: CalendarsDataSource
) : CalendarsDataSource by remoteDataSource