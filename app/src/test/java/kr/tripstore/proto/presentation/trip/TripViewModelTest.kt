package kr.tripstore.proto.presentation.trip

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kr.tripstore.proto.androidtest.MainCoroutineRule
import kr.tripstore.proto.androidtest.util.LiveDataTestUtil
import kr.tripstore.proto.presentation.resource.FakeTripLinkSymbolStringProvider
import kr.tripstore.proto.presentation.resource.TripLinkSymbolStringProvider
import kr.tripstore.proto.shared.data.trip.FakeEmptyTripDataSource
import kr.tripstore.proto.shared.data.trip.FakeErrorTripDataSource
import kr.tripstore.proto.shared.data.trip.FakeTripDataSource
import kr.tripstore.proto.shared.data.trip.TripRepository
import kr.tripstore.proto.shared.domain.trip.GetTripThemesUseCase
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is
import org.hamcrest.core.IsNot
import org.hamcrest.core.IsNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class TripViewModelTest {

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var getTripThemesUseCase: GetTripThemesUseCase
    private lateinit var getEmptyTripThemesUseCase: GetTripThemesUseCase
    private lateinit var getErrorTripThemesUseCase: GetTripThemesUseCase
    private lateinit var tripLinkSymbolStringProvider: TripLinkSymbolStringProvider

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        // Prepare two UseCases
        val tripRepository =
            TripRepository(FakeTripDataSource())
        getTripThemesUseCase =
            GetTripThemesUseCase(
                tripRepository,
                Dispatchers.Unconfined
            )
        val emptyTripRepository =
            TripRepository(
                FakeEmptyTripDataSource()
            )
        getEmptyTripThemesUseCase =
            GetTripThemesUseCase(
                emptyTripRepository,
                Dispatchers.Unconfined
            )
        val errorTripRepository =
            TripRepository(
                FakeErrorTripDataSource()
            )
        getErrorTripThemesUseCase =
            GetTripThemesUseCase(
                errorTripRepository,
                Dispatchers.Unconfined
            )
        tripLinkSymbolStringProvider = FakeTripLinkSymbolStringProvider()
    }

    @Test
    fun loadTripThemes_isEmpty() = mainCoroutineRule.runBlockingTest {
        // Given a TripViewModel with GetTripThemeUseCase that can provide a result which is not empty
        val tripViewModel = TripViewModel(getEmptyTripThemesUseCase, tripLinkSymbolStringProvider)
        // When fetching data from GetTripThemeUseCase
        tripViewModel.start()
        // Then the result is an empty
        val value = LiveDataTestUtil.getValue(tripViewModel.tripThemeItems)
        assertThat(value, IsNull.notNullValue())
        assertThat(value?.size, Is.`is`(0))
    }

    @Test
    fun loadTripThemes_isNotEmpty() = mainCoroutineRule.runBlockingTest {
        // Given a TripViewModel with GetTripThemeUseCase that can provide a result which is not empty
        val tripViewModel = TripViewModel(getTripThemesUseCase, tripLinkSymbolStringProvider)
        // When fetching data from GetTripThemeUseCase
        tripViewModel.start()
        // Then the result is not empty
        LiveDataTestUtil.getValue(tripViewModel.tripThemeItems)?.let {
            assertThat(it, IsNull.notNullValue())
            assertThat(it.size, IsNot.not(0))
        } ?: assert(false)
    }

    @Test
    fun loadTripThemes_isLoading() {
        // Given a TripViewModel with GetTripThemeUseCase that can provide a result which is not empty
        mainCoroutineRule.pauseDispatcher()
        val tripViewModel = TripViewModel(getTripThemesUseCase, tripLinkSymbolStringProvider)
        // When fetching data from GetTripThemeUseCase
        tripViewModel.start()
        // Then the isLoading is false after resume coroutine scope
        assertThat(LiveDataTestUtil.getValue(tripViewModel.isLoading), Is.`is`(true))
        mainCoroutineRule.resumeDispatcher()
        assertThat(LiveDataTestUtil.getValue(tripViewModel.isLoading), Is.`is`(false))
    }

    @Test
    fun loadTripThemes_isError() = mainCoroutineRule.runBlockingTest {
        // Given a TripViewModel with GetTripThemeUseCase that can provide a result which is not empty
        val tripViewModel = TripViewModel(getErrorTripThemesUseCase, tripLinkSymbolStringProvider)
        // When fetching data from GetTripThemeUseCase
        tripViewModel.start()
        // Then the isError is true
        assertThat(LiveDataTestUtil.getValue(tripViewModel.isError), Is.`is`(true))
    }

}