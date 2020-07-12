package kr.tripstore.proto.shared.data.calendar

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

class CalendarsRepositoryTest {

    private lateinit var calendarsRemoteDataSource: CalendarsDataSource

    @get:Rule
    var coroutineRule = MainCoroutineRule()

    @Before
    fun setup() {
        calendarsRemoteDataSource =
            FakeCalendarsRemoteDataSource()
    }

    @Test
    fun getCalendars_isNotNull() =
        coroutineRule.runBlockingTest {
            val fakePlaceIds = arrayOf(478, 479)
            val fakeCityIds = arrayOf(1)
            val fakeThemeIds = null
            // Given a calendars data source
            val calendarsRepository =
                CalendarsRepository(
                    calendarsRemoteDataSource
                )
            // When getting a result of Calendars
            val calendarsResult =
                calendarsRepository.getCalendars(fakePlaceIds, fakeCityIds, fakeThemeIds)
            // Then the result is not null
            assertResult(calendarsResult)
        }

    @Test
    fun getCalendars_isSameAsTestData() =
        coroutineRule.runBlockingTest {
            val fakePlaceIds = arrayOf(478, 479)
            val fakeCityIds = arrayOf(1)
            val fakeThemeIds = null
            // Given a calendars data source
            val calendarsRepository =
                CalendarsRepository(
                    calendarsRemoteDataSource
                )
            // When getting a result of Calendars
            val calendarsResult =
                calendarsRepository.getCalendars(fakePlaceIds, fakeCityIds, fakeThemeIds)
            val data = (calendarsResult as Result.Success).data
            // Then the data is equal to the predefined test data
            assertThat(data, IsEqual.equalTo(TestData.calendars))
        }

}