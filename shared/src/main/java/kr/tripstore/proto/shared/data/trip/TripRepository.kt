package kr.tripstore.proto.shared.data.trip

import kr.tripstore.proto.model.TripPackagePage
import kr.tripstore.proto.shared.data.trip.TripDataSource
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.shared.di.RemoteTripDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TripRepository @Inject constructor(
    @RemoteTripDataSource private val remoteDataSource: TripDataSource
) : TripDataSource {

    override suspend fun getTripPackagePage(): Result<TripPackagePage> =
        remoteDataSource.getTripPackagePage()

}