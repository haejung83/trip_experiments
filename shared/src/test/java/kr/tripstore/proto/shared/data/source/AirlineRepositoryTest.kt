package kr.tripstore.proto.shared.data.source

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kr.tripstore.proto.shared.data.airline.AirlineDataSource
import kr.tripstore.proto.shared.data.airline.AirlineRepository
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.shared.test.util.assertResult
import kr.tripstore.proto.test.data.TestData
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class AirlineRepositoryTest {

    private lateinit var airlineRemoteDateSource: AirlineDataSource

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        airlineRemoteDateSource = FakeAirlineRemoteDateSource()
    }

    @Test
    fun getAirlines_isNotNull() =
        runBlockingTest {
            // Given an airline data source
            val airlineRepository = AirlineRepository(airlineRemoteDateSource)
            // When getting a result of airlines
            val airlinesResult = airlineRepository.getAirlines()
            // Then the result is not null
            assertResult(airlinesResult)
        }

    @Test
    fun getAirlines_isSameAsTestData() =
        runBlockingTest {
            // Given an airline data source
            val airlineRepository = AirlineRepository(airlineRemoteDateSource)
            // When getting a result of airlines
            val airlinesResult = airlineRepository.getAirlines()
            val data = (airlinesResult as Result.Success).data

            // Then the result is not null
            assertThat(data, IsEqual.equalTo(TestData.airlines.airlines))
        }

}