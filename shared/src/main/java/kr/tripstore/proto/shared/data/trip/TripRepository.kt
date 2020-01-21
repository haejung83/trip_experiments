package kr.tripstore.proto.shared.data.trip

import kr.tripstore.proto.shared.di.RemoteTripDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TripRepository @Inject constructor(
    @RemoteTripDataSource private val remoteDataSource: TripDataSource
) : TripDataSource by remoteDataSource
