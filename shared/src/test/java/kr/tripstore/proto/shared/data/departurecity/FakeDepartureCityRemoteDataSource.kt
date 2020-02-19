package kr.tripstore.proto.shared.data.departurecity

import kr.tripstore.proto.model.DepartureCity
import kr.tripstore.proto.shared.data.departurecity.DepartureCityDataSource
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.test.data.TestData

class FakeDepartureCityRemoteDataSource : DepartureCityDataSource {

    override suspend fun getDepartureCities(): Result<List<DepartureCity>> =
        Result.Success(TestData.departureCities.departureCities)

    override suspend fun getDepartureCityById(id: Int): Result<DepartureCity> =
        Result.Success(TestData.departureCity)

}