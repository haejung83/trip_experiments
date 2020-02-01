package kr.tripstore.proto.shared.data.trip

import kr.tripstore.proto.model.TripPackagePage
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject

class TripRemoteDataSource @Inject constructor() : TripDataSource {

    private val tripPackagePageAPI = TripPackagePageAPI.create()

    override suspend fun getTripPackagePage(): Result<TripPackagePage> {
        val response = tripPackagePageAPI.getTripPackagePage()
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.Success(it)
            } ?: Result.Error(Exception("TripRemoteDataSource: is not available"))
        } else {
            Result.Error(Exception("TripRemoteDataSource: Error"))
        }
    }

}