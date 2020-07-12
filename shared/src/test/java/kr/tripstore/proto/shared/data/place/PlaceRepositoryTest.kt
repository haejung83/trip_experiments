package kr.tripstore.proto.shared.data.place

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

class PlaceRepositoryTest {

    private lateinit var placeRemoteDataSource: PlaceDataSource

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        placeRemoteDataSource = FakePlaceRemoteDataSource()
    }

    @Test
    fun getPlaces_isNotNull() =
        coroutineRule.runBlockingTest {
            val fakeDepartureCityIds = arrayOf(1)
            // Given a place data source
            val placeRepository =
                PlaceRepository(
                    placeRemoteDataSource
                )
            // When getting a result of places
            val placesResult = placeRepository.getPlaces(fakeDepartureCityIds)
            // Then the result is not null
            assertResult(placesResult)
        }

    @Test
    fun getPlaces_isSameAsTestData() =
        coroutineRule.runBlockingTest {
            val fakeDepartureCityIds = arrayOf(1)
            // Given a place data source
            val placeRepository =
                PlaceRepository(
                    placeRemoteDataSource
                )
            // When getting a result of places
            val placesResult = placeRepository.getPlaces(fakeDepartureCityIds)
            val data = (placesResult as Result.Success).data
            // Then the data is equual to the predefined test data
            assertThat(data, IsEqual.equalTo(TestData.places.places))
        }

}