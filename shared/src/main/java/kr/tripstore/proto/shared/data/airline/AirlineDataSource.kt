package kr.tripstore.proto.shared.data.airline

import kr.tripstore.proto.model.Airline
import kr.tripstore.proto.shared.result.Result

interface AirlineDataSource {

    suspend fun getAirlines(): Result<List<Airline>>
    suspend fun getAirlineById(id: Int): Result<Airline>

}