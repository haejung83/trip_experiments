package kr.tripstore.proto.shared.data.place

import kr.tripstore.proto.model.Place
import kr.tripstore.proto.shared.extension.toArrayValueWrapper
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject

class PlaceRemoteDataSource @Inject constructor() : PlaceDataSource {

    private val placeAPI = PlaceAPI.create()

    override suspend fun getPlaces(departureCityIds: Array<Int>): Result<List<Place>> {
        val response = placeAPI.getPlaces(departureCityIds.toArrayValueWrapper())
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.Success(it.places)
            } ?: Result.Error(Exception("PlaceRemoteDataSource: is not available"))
        } else {
            Result.Error(Exception("PlaceRemoteDataSource: Error"))
        }
    }

}