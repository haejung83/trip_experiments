package kr.tripstore.proto.shared.data.place

import kr.tripstore.proto.model.Place
import kr.tripstore.proto.shared.result.Result

interface PlaceDataSource {

    suspend fun getPlaces(departureCityIds: Array<Int>): Result<List<Place>>

}