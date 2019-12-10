package kr.tripstore.proto.shared.data.source

import kr.tripstore.proto.model.TripPackagePage
import kr.tripstore.proto.shared.data.Result

interface TripDataSource {

    suspend fun getTripPackagePage(): Result<TripPackagePage>

}