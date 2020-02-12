package kr.tripstore.proto.shared.data.agency

import kr.tripstore.proto.model.Agency
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject

class AgencyLocalDataSource @Inject constructor() : AgencyCacheDataSource {

    private val cache: MutableMap<Int, Agency> = mutableMapOf()

    override suspend fun cache(agencies: List<Agency>) {
        cache.clear()
        agencies.forEach { cache[it.id] = it }
    }

    override suspend fun getAgencies(): Result<List<Agency>> =
        if (cache.isNotEmpty())
            Result.Success(cache.values.toList())
        else
            Result.Error(Exception("Empty agencies"))

    override suspend fun getAgencyById(id: Int): Result<Agency> =
        if (cache.containsKey(id))
            Result.Success(cache.getValue(id))
        else
            Result.Error(Exception("Not exists with $id"))

    override suspend fun size(): Int = cache.size

}