package kr.tripstore.proto.shared.data.departurecity

import kr.tripstore.proto.model.DepartureCity
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject

class DepartureCityRemoteDataSource @Inject constructor() : DepartureCityDataSource {

    private val departureCityAPI = DepartureCityAPI.create()

    override suspend fun getDepartureCities(): Result<List<DepartureCity>> {
        val response = departureCityAPI.getCities()
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.Success(it.departureCities)
            } ?: Result.Error(Exception("DepartureCityRemoteDataSource: is not available"))
        } else {
            Result.Error(Exception("DepartureCityRemoteDataSource: Error"))
        }
    }

    override suspend fun getDepartureCityById(id: Int): Result<DepartureCity> =
        Result.Error(Exception("Unsupported method"))

}