package kr.tripstore.proto.shared.data.trip

import kr.tripstore.proto.model.TripPackagePage
import kr.tripstore.proto.shared.result.Result

interface TripDataSource {

    suspend fun getTripPackagePage(): Result<TripPackagePage>

}