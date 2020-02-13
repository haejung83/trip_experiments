package kr.tripstore.proto.shared.data.airline

import kr.tripstore.proto.model.Airline
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject

class AirlineRemoteDataSource @Inject constructor() : AirlineDataSource {

    private val airlineAPI = AirlineAPI.create()

    override suspend fun getAirlines(): Result<List<Airline>> {
        val response = airlineAPI.getAirlines()
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.Success(it.airlines)
            } ?: Result.Error(Exception("AirlineRemoteDataSource: is not available"))
        } else {
            Result.Error(Exception("AirlineRemoteDataSource: Error"))
        }
    }

    override suspend fun getAirlineById(id: Int): Result<Airline> =
        Result.Error(Exception("Unsupported method"))

}