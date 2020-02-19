package kr.tripstore.proto.shared.data.temperature

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kr.tripstore.proto.shared.data.temperature.FakeTemperaturesRemoteDataSource
import kr.tripstore.proto.shared.data.temperature.TemperaturesDataSource
import kr.tripstore.proto.shared.data.temperature.TemperaturesRepository
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.shared.test.util.assertResult
import kr.tripstore.proto.test.data.TestData
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class TemperaturesRepositoryTest {

    private lateinit var temperaturesRemoteDataSource: TemperaturesDataSource

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        temperaturesRemoteDataSource =
            FakeTemperaturesRemoteDataSource()
    }

    @Test
    fun getTemperatures_isNotNull() =
        runBlockingTest {
            val fakePlaceId = 479
            // Given a temperature data source
            val temperaturesRepository =
                TemperaturesRepository(
                    temperaturesRemoteDataSource
                )
            // When getting a result of temperature
            val temperaturesResult = temperaturesRepository.getTemperatures(fakePlaceId)
            // Then the result is not null
            assertResult(temperaturesResult)
        }

    @Test
    fun getTemperatures_isSameAsTestData() =
        runBlockingTest {
            val fakePlaceId = 479
            // Given a temperature data source
            val temperaturesRepository =
                TemperaturesRepository(
                    temperaturesRemoteDataSource
                )
            // When getting a result of temperature
            val temperaturesResult = temperaturesRepository.getTemperatures(fakePlaceId)
            val data = (temperaturesResult as Result.Success).data
            // Then the data is equal to the predefined test data
            assertThat(data, IsEqual.equalTo(TestData.temperatures))
        }

}