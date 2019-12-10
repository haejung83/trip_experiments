package kr.tripstore.proto.shared.data.source

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kr.tripstore.proto.shared.data.Result
import kr.tripstore.proto.test.data.TestData
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.hamcrest.core.IsInstanceOf
import org.hamcrest.core.IsNull
import org.junit.After
import org.junit.Before
import org.junit.Test
import timber.log.Timber

@ExperimentalCoroutinesApi
class TripRepositoryTest {

    private lateinit var tripRemoteDataSource: TripDataSource
    private lateinit var tripRepository: TripRepository

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        Timber.v("Start")
        tripRemoteDataSource = FakeRemoteTripDataSource()
        tripRepository = TripRepository(tripRemoteDataSource)
    }

    @ExperimentalCoroutinesApi
    @After
    fun tear() {
        Timber.v("End")
    }

    @Test
    fun getTripPackagePage_receivedFromRemote() =
        runBlockingTest {
            val tripPackagePageResult = tripRepository.getTripPackagePage()

            assertThat(tripPackagePageResult, IsNull.notNullValue())
            assertThat(tripPackagePageResult, IsInstanceOf.instanceOf(Result.Success::class.java))
            assertThat(
                (tripPackagePageResult as Result.Success).data,
                IsEqual.equalTo(TestData.tripPackagePage)
            )
        }

}