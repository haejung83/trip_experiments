package kr.tripstore.proto.shared.data.temperature

import kr.tripstore.proto.model.Temperatures
import kr.tripstore.proto.shared.result.Result

interface TemperaturesDataSource {

    suspend fun getTemperatures(placeId: Int): Result<Temperatures>

}