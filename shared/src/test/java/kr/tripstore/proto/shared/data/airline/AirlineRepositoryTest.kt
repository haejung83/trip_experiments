package kr.tripstore.proto.shared.data.airline

import kr.tripstore.proto.androidtest.MainCoroutineRule
import kr.tripstore.proto.androidtest.runBlockingTest
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.shared.test.util.assertResult
import kr.tripstore.proto.test.data.TestData
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AirlineRepositoryTest {

    private lateinit var airlineRemoteDateSource: AirlineDataSource

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        airlineRemoteDateSource = FakeAirlineRemoteDateSource()
    }

    @Test
    fun getAirlines_isNotNull() =
        coroutineRule.runBlockingTest {
            // Given an airline data source
            val airlineRepository = AirlineRepository(airlineRemoteDateSource)
            // When getting a result of airlines
            val airlinesResult = airlineRepository.getAirlines()
            // Then the result is not null
            assertResult(airlinesResult)
        }

    @Test
    fun getAirlines_isSameAsTestData() =
        coroutineRule.runBlockingTest {
            // Given an airline data source
            val airlineRepository = AirlineRepository(airlineRemoteDateSource)
            // When getting a result of airlines
            val airlinesResult = airlineRepository.getAirlines()
            val data = (airlinesResult as Result.Success).data
            // Then the data is equal to the predefined test data
            assertThat(data, IsEqual.equalTo(TestData.airlines.airlines))
        }

}