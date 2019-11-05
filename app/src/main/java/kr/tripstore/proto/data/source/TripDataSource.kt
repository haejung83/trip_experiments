package kr.tripstore.proto.data.source

import kr.tripstore.proto.data.Result
import kr.tripstore.proto.data.TripPackagePage

interface TripDataSource {

    suspend fun getTripPackagePage(): Result<TripPackagePage>

}