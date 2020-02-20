package kr.tripstore.proto.shared.data.place

import kr.tripstore.proto.model.Place
import kr.tripstore.proto.shared.di.RemoteDataSource
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlaceRepository @Inject constructor(
    @RemoteDataSource private val remotePlaceDataSource: PlaceDataSource
) : PlaceDataSource {

    override suspend fun getPlaces(departureCityIds: Array<Int>): Result<List<Place>> {
        val getPlaceResult = remotePlaceDataSource.getPlaces(departureCityIds)
        return if (getPlaceResult is Result.Success) {
            Result.Success(getPlaceResult.data)
        } else {
            Result.Error(Exception("Place not exists with $departureCityIds"))
        }
    }

}