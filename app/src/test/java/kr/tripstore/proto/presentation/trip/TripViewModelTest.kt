package kr.tripstore.proto.presentation.trip

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kr.tripstore.proto.androidtest.MainCoroutineRule
import kr.tripstore.proto.androidtest.util.LiveDataTestUtil
import kr.tripstore.proto.shared.data.FakeEmptyTripDataSource
import kr.tripstore.proto.shared.data.FakeErrorTripDataSource
import kr.tripstore.proto.shared.data.FakeTripDataSource
import kr.tripstore.proto.shared.data.source.TripRepository
import kr.tripstore.proto.shared.domain.GetTripThemesUseCase
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

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        // Prepare two UseCases
        val tripRepository = TripRepository(FakeTripDataSource())
        getTripThemesUseCase = GetTripThemesUseCase(tripRepository)
        val emptyTripRepository = TripRepository(FakeEmptyTripDataSource())
        getEmptyTripThemesUseCase = GetTripThemesUseCase(emptyTripRepository)
        val errorTripRepository = TripRepository(FakeErrorTripDataSource())
        getErrorTripThemesUseCase = GetTripThemesUseCase(errorTripRepository)
    }

    @Test
    fun loadTripThemes_isEmpty() = mainCoroutineRule.runBlockingTest {
        // Given a TripViewModel with GetTripThemeUseCase that can provide a result which is not empty
        val tripViewModel = TripViewModel(getEmptyTripThemesUseCase)
        // When fetching data from GetTripThemeUseCase
        tripViewModel.start()
        // Then the result is an empty
        val value = LiveDataTestUtil.getValue(tripViewModel.tripThemes)
        assertThat(value, IsNull.notNullValue())
        assertThat(value?.size, Is.`is`(0))
    }

    @Test
    fun loadTripThemes_isNotEmpty() = mainCoroutineRule.runBlockingTest {
        // Given a TripViewModel with GetTripThemeUseCase that can provide a result which is not empty
        val tripViewModel = TripViewModel(getTripThemesUseCase)
        // When fetching data from GetTripThemeUseCase
        tripViewModel.start()
        // Then the result is not empty
        LiveDataTestUtil.getValue(tripViewModel.tripThemes)?.let {
            assertThat(it, IsNull.notNullValue())
            assertThat(it.size, IsNot.not(0))
        } ?: assert(false)
    }

    @Test
    fun loadTripThemes_isLoading() {
        // Given a TripViewModel with GetTripThemeUseCase that can provide a result which is not empty
        mainCoroutineRule.pauseDispatcher()
        val tripViewModel = TripViewModel(getTripThemesUseCase)
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
        val tripViewModel = TripViewModel(getErrorTripThemesUseCase)
        // When fetching data from GetTripThemeUseCase
        tripViewModel.start()
        // Then the isError is true
        assertThat(LiveDataTestUtil.getValue(tripViewModel.isError), Is.`is`(true))
    }

}