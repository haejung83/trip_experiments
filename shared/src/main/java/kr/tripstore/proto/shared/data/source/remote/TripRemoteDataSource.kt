package kr.tripstore.proto.shared.data.source.remote

import kr.tripstore.proto.model.TripPackagePage
import kr.tripstore.proto.shared.data.Result
import kr.tripstore.proto.shared.data.source.TripDataSource
import javax.inject.Inject

class TripRemoteDataSource @Inject constructor() : TripDataSource {

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