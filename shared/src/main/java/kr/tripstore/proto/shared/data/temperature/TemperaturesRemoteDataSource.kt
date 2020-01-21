package kr.tripstore.proto.shared.data.temperature

import kr.tripstore.proto.model.Temperatures
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject

class TemperaturesRemoteDataSource @Inject constructor() : TemperaturesDataSource {

    private val temperaturesAPI = TemperaturesAPI.create()

    override suspend fun getTemperatures(placeId: Int): Result<Temperatures> {
        val response = temperaturesAPI.getTemperatures(placeId)
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.Success(it)
            } ?: Result.Error(Exception("No Data"))
        } else {
            Result.Error(Exception("Error"))
        }
    }

}