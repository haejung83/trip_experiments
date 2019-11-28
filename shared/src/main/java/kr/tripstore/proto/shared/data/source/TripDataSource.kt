package kr.tripstore.proto.shared.data.source

import kr.tripstore.proto.shared.data.Result
import kr.tripstore.proto.model.TripPackagePage

interface TripDataSource {

    suspend fun getTripPackagePage(): Result<TripPackagePage>

}