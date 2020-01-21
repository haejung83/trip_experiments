package kr.tripstore.proto.shared.data.source

import kr.tripstore.proto.model.Temperatures
import kr.tripstore.proto.shared.data.temperature.TemperaturesDataSource
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.test.data.TestData

class FakeTemperaturesRemoteDataSource : TemperaturesDataSource {

    override suspend fun getTemperatures(placeId: Int): Result<Temperatures> =
        Result.Success(TestData.temperatures)

}