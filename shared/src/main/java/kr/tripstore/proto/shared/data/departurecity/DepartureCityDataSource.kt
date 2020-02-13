package kr.tripstore.proto.shared.data.departurecity

import kr.tripstore.proto.model.DepartureCity
import kr.tripstore.proto.shared.result.Result

interface DepartureCityDataSource {

    suspend fun getDepartureCities(): Result<List<DepartureCity>>
    suspend fun getDepartureCityById(id: Int): Result<DepartureCity>

}