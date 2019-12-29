package kr.tripstore.proto.shared.data.source

import kr.tripstore.proto.model.TripPackagePage
import kr.tripstore.proto.shared.data.trip.TripDataSource
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.test.data.TestData

class FakeRemoteTripDataSource :
    TripDataSource {

    override suspend fun getTripPackagePage(): Result<TripPackagePage> =
        Result.Success(TestData.tripPackagePage)

}