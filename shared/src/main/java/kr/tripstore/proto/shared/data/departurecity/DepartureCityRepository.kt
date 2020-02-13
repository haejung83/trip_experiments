package kr.tripstore.proto.shared.data.departurecity

import kr.tripstore.proto.model.DepartureCity
import kr.tripstore.proto.shared.di.RemoteDataSource
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DepartureCityRepository @Inject constructor(
    @RemoteDataSource private val remoteDepartureCityDataSource: DepartureCityDataSource
) : DepartureCityDataSource {

    private var cache: Map<Int, DepartureCity> = emptyMap()

    override suspend fun getDepartureCities(): Result<List<DepartureCity>> {
        fetchAndCacheDepartureCitiesIfNeeds()
        return Result.Success(cache.values.toList())
    }

    override suspend fun getDepartureCityById(id: Int): Result<DepartureCity> {
        fetchAndCacheDepartureCitiesIfNeeds()
        return if (cache.containsKey(id))
            Result.Success(cache.getValue(id))
        else
            Result.Error(Exception("DepartureCity not exists with $id"))
    }

    private suspend fun fetchAndCacheDepartureCitiesIfNeeds() {
        if (cache.isEmpty()) {
            val getDepartureCityResult = remoteDepartureCityDataSource.getDepartureCities()
            if (getDepartureCityResult is Result.Success) {
                cache = getDepartureCityResult.data.map { it.id to it }.toMap()
            }
        }
    }

}