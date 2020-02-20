package kr.tripstore.proto.presentation.search

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kr.tripstore.proto.androidtest.MainCoroutineRule
import kr.tripstore.proto.androidtest.util.LiveDataTestUtil
import kr.tripstore.proto.shared.data.trip.FakeTripDataSource
import kr.tripstore.proto.shared.data.trip.TripRepository
import kr.tripstore.proto.shared.domain.trip.GetTripPackagePageUseCase
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsNot
import org.hamcrest.core.IsNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class SearchViewModelTest {

    // Executes each task synchronously using Architecture Components.
    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var getTripPackagePageUseCase: GetTripPackagePageUseCase

    // Set the main coroutines dispatcher for unit testing.
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        val tripDataSource =
            FakeTripDataSource()
        val tripRepository =
            TripRepository(tripDataSource)
        getTripPackagePageUseCase =
            GetTripPackagePageUseCase(
                tripRepository,
                Dispatchers.Unconfined
            )
    }

    @Test
    fun getTripPackagePage_isNotEmpty() = mainCoroutineRule.runBlockingTest {
        // Given a SearchViewModel with GetTripPackagePageUseCase that can provide a result which is not empty
        val searchViewModel = SearchViewModel(getTripPackagePageUseCase)
        // When fetching data from GetTripPackagePageUseCase
        searchViewModel.start()
        // Then the count of list is an empty
        LiveDataTestUtil.getValue(searchViewModel.displayCount)?.let {
            assertThat(it, IsNull.notNullValue())
            assertThat(it.length, IsNot.not(0))
        }
    }

}