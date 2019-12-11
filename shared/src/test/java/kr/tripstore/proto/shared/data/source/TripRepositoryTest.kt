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
            val tripPackagePageResult = TripRepository(tripRemoteDataSource).getTripPackagePage()
            assertResult(tripPackagePageResult)
        }

    @Test
    fun getTripPackagePage_isSameAsTestData() =
        runBlockingTest {
            val tripPackagePageResult = TripRepository(tripRemoteDataSource).getTripPackagePage()
            assertThat(
                (tripPackagePageResult as Result.Success).data,
                IsEqual.equalTo(TestData.tripPackagePage)
            )
        }

}