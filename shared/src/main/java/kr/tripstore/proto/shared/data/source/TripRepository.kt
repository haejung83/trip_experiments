package kr.tripstore.proto.shared.data.source

import kr.tripstore.proto.shared.data.Result
import kr.tripstore.proto.model.TripPackagePage
import kr.tripstore.proto.shared.data.source.remote.TripRemoteDataSource

class TripRepository : TripDataSource {

    private val remoteDataSource = TripRemoteDataSource()

    override suspend fun getTripPackagePage(): Result<TripPackagePage> =
        remoteDataSource.getTripPackagePage()

}