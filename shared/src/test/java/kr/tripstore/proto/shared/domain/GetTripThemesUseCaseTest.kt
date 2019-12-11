package kr.tripstore.proto.shared.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kr.tripstore.proto.shared.data.Result
import kr.tripstore.proto.shared.data.source.FakeRemoteTripDataSource
import kr.tripstore.proto.shared.data.source.TripRepository
import kr.tripstore.proto.shared.test.util.assertResult
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsNot
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetTripThemesUseCaseTest {

    private lateinit var tripRepository: TripRepository

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        tripRepository = TripRepository(FakeRemoteTripDataSource())
    }

    @Test
    fun getTripThemesUseCase_isNotNull() =
        runBlockingTest {
            val getTripThemesUseCaseResult = GetTripThemesUseCase(tripRepository).invoke()
            assertResult(getTripThemesUseCaseResult)
        }

    @Test
    fun getTripThemesUseCase_checkResultIsNotEmpty() =
        runBlockingTest {
            val getTripThemesUseCaseResult = GetTripThemesUseCase(tripRepository).invoke()
            val data = (getTripThemesUseCaseResult as Result.Success).data
            assertThat(data.size, IsNot.not(0))
        }

}