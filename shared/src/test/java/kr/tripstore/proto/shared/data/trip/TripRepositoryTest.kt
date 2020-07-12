package kr.tripstore.proto.shared.data.trip

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

class TripRepositoryTest {

    private lateinit var tripRemoteDataSource: TripDataSource

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        tripRemoteDataSource = FakeRemoteTripDataSource()
    }

    @Test
    fun getTripPackagePage_isNotNull() =
        coroutineRule.runBlockingTest {
            // Given a trip data source
            val tripRepository =
                TripRepository(
                    tripRemoteDataSource
                )
            // When getting a result of TripPackagePage
            val tripPackagePageResult = tripRepository.getTripPackagePage()
            // Then the result is not null
            assertResult(tripPackagePageResult)
        }

    @Test
    fun getTripPackagePage_isSameAsTestData() =
        coroutineRule.runBlockingTest {
            // Given a trip data source
            val tripRepository =
                TripRepository(
                    tripRemoteDataSource
                )
            // When getting a result of TripPackagePage
            val tripPackagePageResult = tripRepository.getTripPackagePage()
            val data = (tripPackagePageResult as Result.Success).data
            // Then the data is equal to the predefined test data
            assertThat(data, IsEqual.equalTo(TestData.tripPackagePage))
        }

}