package kr.tripstore.proto.shared.data.place

import kr.tripstore.proto.model.Place
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.test.data.TestData

class FakePlaceRemoteDataSource : PlaceDataSource {

    override suspend fun getPlaces(departureCityIds: Array<Int>): Result<List<Place>> =
        Result.Success(TestData.places.places)

}