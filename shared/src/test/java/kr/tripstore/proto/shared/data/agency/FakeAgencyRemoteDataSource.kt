package kr.tripstore.proto.shared.data.agency

import kr.tripstore.proto.model.Agency
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.test.data.TestData

class FakeAgencyRemoteDataSource : AgencyDataSource {

    override suspend fun getAgencies(): Result<List<Agency>> =
        Result.Success(TestData.agencies.agencies)

    override suspend fun getAgencyById(id: Int): Result<Agency> =
        Result.Success(TestData.agencies.agencies.first())

}