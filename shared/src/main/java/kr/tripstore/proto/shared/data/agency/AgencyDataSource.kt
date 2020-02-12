package kr.tripstore.proto.shared.data.agency

import kr.tripstore.proto.model.Agency
import kr.tripstore.proto.shared.result.Result

interface AgencyDataSource {

    suspend fun getAgencies(): Result<List<Agency>>
    suspend fun getAgencyById(id: Int): Result<Agency>

}

interface AgencyCacheDataSource : AgencyDataSource {

    suspend fun cache(agencies: List<Agency>)
    suspend fun size(): Int

}