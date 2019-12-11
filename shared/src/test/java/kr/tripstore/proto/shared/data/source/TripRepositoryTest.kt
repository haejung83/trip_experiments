package kr.tripstore.proto.shared.data.source

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kr.tripstore.proto.shared.data.Result
import kr.tripstore.proto.shared.test.util.assertResult
import kr.tripstore.proto.test.data.TestData
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class TripRepositoryTest {

    private lateinit var tripRemoteDataSource: TripDataSource

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        tripRemoteDataSource = FakeRemoteTripDataSource()
    }

    @Test
    fun getTripPackagePage_isNotNull() =
        runBlockingTest {
            // Given a trip data source
            val tripRepository = TripRepository(tripRemoteDataSource)
            // When getting a result of TripPackagePage
            val tripPackagePageResult = tripRepository.getTripPackagePage()
            // Then the result is not null
            assertResult(tripPackagePageResult)
        }

    @Test
    fun getTripPackagePage_isSameAsTestData() =
        runBlockingTest {
            // Given a trip data source
            val tripRepository = TripRepository(tripRemoteDataSource)
            // When getting a result of TripPackagePage
            val tripPackagePageResult = tripRepository.getTripPackagePage()
            val data = (tripPackagePageResult as Result.Success).data
            // Then the data is equal to the predefined test data
            assertThat(data, IsEqual.equalTo(TestData.tripPackagePage))
        }

}