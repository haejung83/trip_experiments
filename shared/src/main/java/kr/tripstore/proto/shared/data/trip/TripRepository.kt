package kr.tripstore.proto.shared.data.trip

import kr.tripstore.proto.shared.di.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TripRepository @Inject constructor(
    @RemoteDataSource private val remoteDataSource: TripDataSource
) : TripDataSource by remoteDataSource
