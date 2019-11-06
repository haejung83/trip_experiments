package kr.tripstore.proto.data.source.remote

import kr.tripstore.proto.data.Result
import kr.tripstore.proto.data.TripPackagePage
import kr.tripstore.proto.data.source.TripDataSource

class TripRemoteDataSource : TripDataSource {

    private val tripPackagePageAPI = TripPackagePageAPI.create()

    override suspend fun getTripPackagePage(): Result<TripPackagePage> {
        val response = tripPackagePageAPI.getTripPackagePage()
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.Success(it)
            } ?: Result.Error(Exception("No Data"))
        } else {
            Result.Error(Exception("Error"))
        }
    }

}