package kr.tripstore.proto.data.source

import kr.tripstore.proto.data.Result
import kr.tripstore.proto.data.TripPackagePage
import kr.tripstore.proto.data.source.remote.TripRemoteDataSource

class TripRepository : TripDataSource {

    private val remoteDataSource = TripRemoteDataSource()

    override suspend fun getTripPackagePage(): Result<TripPackagePage> =
        remoteDataSource.getTripPackagePage()

}