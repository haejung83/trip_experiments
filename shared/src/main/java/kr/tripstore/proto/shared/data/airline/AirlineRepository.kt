package kr.tripstore.proto.shared.data.airline

import kr.tripstore.proto.model.Airline
import kr.tripstore.proto.shared.di.RemoteDataSource
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AirlineRepository @Inject constructor(
    @RemoteDataSource private val remoteAirlineDataSource: AirlineDataSource
) : AirlineDataSource {

    private var cache: Map<Int, Airline> = emptyMap()

    override suspend fun getAirlines(): Result<List<Airline>> {
        fetchAndCacheAirlinesIfNeeds()
        return Result.Success(cache.values.toList())
    }

    override suspend fun getAirlineById(id: Int): Result<Airline> {
        fetchAndCacheAirlinesIfNeeds()
        return if (cache.containsKey(id))
            Result.Success(cache.getValue(id))
        else
            Result.Error(Exception("Airline not exists with $id"))
    }

    private suspend fun fetchAndCacheAirlinesIfNeeds() {
        if (cache.isEmpty()) {
            val getAirlineResult = remoteAirlineDataSource.getAirlines()
            if (getAirlineResult is Result.Success) {
                cache = getAirlineResult.data.map { it.id to it }.toMap()
            }
        }
    }

}