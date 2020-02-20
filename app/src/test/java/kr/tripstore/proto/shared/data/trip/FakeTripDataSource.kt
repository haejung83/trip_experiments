package kr.tripstore.proto.shared.data.trip

import kr.tripstore.proto.model.TripPackagePage
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.test.data.TestData

internal class FakeTripDataSource :
    TripDataSource {
    override suspend fun getTripPackagePage(): Result<TripPackagePage> =
        Result.Success(TestData.tripPackagePage)
}

internal class FakeEmptyTripDataSource :
    TripDataSource {
    override suspend fun getTripPackagePage(): Result<TripPackagePage> =
        Result.Success(TestData.emptyTripPackagePage)
}

internal class FakeErrorTripDataSource :
    TripDataSource {
    override suspend fun getTripPackagePage(): Result<TripPackagePage> =
        Result.Error(Exception("A Fake error for TripDataSource"))
}