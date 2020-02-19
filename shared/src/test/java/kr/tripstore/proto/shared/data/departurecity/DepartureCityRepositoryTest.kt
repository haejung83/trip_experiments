package kr.tripstore.proto.shared.data.departurecity

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.shared.test.util.assertResult
import kr.tripstore.proto.test.data.TestData
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class DepartureCityRepositoryTest {

    private lateinit var departureCityRemoteDataSource: DepartureCityDataSource

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        departureCityRemoteDataSource =
            FakeDepartureCityRemoteDataSource()
    }

    @Test
    fun getDepartureCities_isNotNull() =
        runBlocking {
            // Given a departure city data source
            val departureCityRepository = DepartureCityRepository(departureCityRemoteDataSource)
            // When getting a result of departureCity
            val departureCitiesResult = departureCityRepository.getDepartureCities()
            // Then the result is not null
            assertResult(departureCitiesResult)
        }

    @Test
    fun getDepartureCities_isSameAsTestData() =
        runBlocking {
            // Given a departure city data source
            val departureCityRepository = DepartureCityRepository(departureCityRemoteDataSource)
            // When getting a result of departureCity
            val departureCitiesResult = departureCityRepository.getDepartureCities()
            val data = (departureCitiesResult as Result.Success).data
            // Then the data is equal to the predefined test data
            assertThat(data, IsEqual.equalTo(TestData.departureCities.departureCities))
        }

    @Test
    fun getDepartureCityById_isNotNull() =
        runBlocking {
            val fakeDepartureId = 1
            // Given a departure city data source
            val departureCityRepository = DepartureCityRepository(departureCityRemoteDataSource)
            // When getting a result of departureCity
            val departureCityResult = departureCityRepository.getDepartureCityById(fakeDepartureId)
            // Then the result is not null
            assertResult(departureCityResult)
        }

    @Test
    fun getDepartureCityById_isSameAsTestData() =
        runBlocking {
            val fakeDepartureId = 1
            // Given a departure city data source
            val departureCityRepository = DepartureCityRepository(departureCityRemoteDataSource)
            // When getting a result of departureCity
            val departureCityResult = departureCityRepository.getDepartureCityById(fakeDepartureId)
            val data = (departureCityResult as Result.Success).data
            // Then the data is equal to the predefined test data
            assertThat(data, IsEqual.equalTo(TestData.departureCity))
        }

}