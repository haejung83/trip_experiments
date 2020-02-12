package kr.tripstore.proto.shared.data.agency

import kr.tripstore.proto.model.Agency
import kr.tripstore.proto.shared.di.LocalDataSource
import kr.tripstore.proto.shared.di.RemoteDataSource
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AgencyRepository @Inject constructor(
    @RemoteDataSource private val remoteAgencyDataSource: AgencyDataSource,
    @LocalDataSource private val localAgencyDataSource: AgencyCacheDataSource
) : AgencyDataSource {

    override suspend fun getAgencies(): Result<List<Agency>> {
        checkAndCacheIfNeeds()
        return localAgencyDataSource.getAgencies()
    }

    override suspend fun getAgencyById(id: Int): Result<Agency> {
        checkAndCacheIfNeeds()
        return localAgencyDataSource.getAgencyById(id)
    }

    private suspend fun checkAndCacheIfNeeds() {
        if (localAgencyDataSource.size() == 0) {
            val getAgencyResult = remoteAgencyDataSource.getAgencies()
            if (getAgencyResult is Result.Success) {
                localAgencyDataSource.cache(getAgencyResult.data)
            }
        }
    }

}