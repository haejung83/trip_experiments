package kr.tripstore.proto.shared.data.agency

import kr.tripstore.proto.model.Agency
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject

class AgencyRemoteDataSource @Inject constructor() : AgencyDataSource {

    private val agencyAPI = AgencyAPI.create()

    override suspend fun getAgencies(): Result<List<Agency>> {
        val response = agencyAPI.getAgencies()
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.Success(it.agencies)
            } ?: Result.Error(Exception("AgencyRemoteDataSource: is not available"))
        } else {
            Result.Error(Exception("AgencyRemoteDataSource: Error"))
        }
    }

    override suspend fun getAgencyById(id: Int): Result<Agency> =
        Result.Error(Exception("Unsupported method"))

}