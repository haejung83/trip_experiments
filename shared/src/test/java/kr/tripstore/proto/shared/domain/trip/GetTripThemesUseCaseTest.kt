package kr.tripstore.proto.shared.domain.trip

import kotlinx.coroutines.Dispatchers
import kr.tripstore.proto.androidtest.MainCoroutineRule
import kr.tripstore.proto.androidtest.runBlockingTest
import kr.tripstore.proto.shared.data.trip.FakeRemoteTripDataSource
import kr.tripstore.proto.shared.data.trip.TripRepository
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.shared.test.util.assertResult
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsNot
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class GetTripThemesUseCaseTest {

    private lateinit var tripRepository: TripRepository

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        tripRepository = TripRepository(FakeRemoteTripDataSource())
    }

    @Test
    fun getTripThemesUseCase_isNotNull() =
        coroutineRule.runBlockingTest {
            // Given a trip repository with a FakeRemoteTripDataSource that returns the predefined result at TestData
            val getTripThemesUseCase =
                GetTripThemesUseCase(
                    tripRepository,
                    Dispatchers.Unconfined
                )
            // When getting a result of TripTheme
            val getTripThemesUseCaseResult = getTripThemesUseCase.invoke()
            // Then the result is not null
            assertResult(getTripThemesUseCaseResult)
        }

    @Test
    fun getTripThemesUseCase_checkResultIsNotEmpty() =
        coroutineRule.runBlockingTest {
            // Given a trip repository with a FakeRemoteTripDataSource that returns the predefined result at TestData
            val getTripThemesUseCase =
                GetTripThemesUseCase(
                    tripRepository,
                    Dispatchers.Unconfined
                )
            // When getting TripThemes
            val getTripThemesUseCaseResult = getTripThemesUseCase.invoke()
            val data = (getTripThemesUseCaseResult as Result.Success).data
            // Then the data is not empty
            assertThat(data.size, IsNot.not(0))
        }

}