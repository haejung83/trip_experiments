package kr.tripstore.proto.shared.data.airline

import kr.tripstore.proto.model.Airline
import kr.tripstore.proto.shared.data.airline.AirlineDataSource
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.test.data.TestData

class FakeAirlineRemoteDateSource : AirlineDataSource {

    override suspend fun getAirlines(): Result<List<Airline>> =
        Result.Success(TestData.airlines.airlines)

    override suspend fun getAirlineById(id: Int): Result<Airline> =
        Result.Success(TestData.airline)

}