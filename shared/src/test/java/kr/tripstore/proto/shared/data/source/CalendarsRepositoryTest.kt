package kr.tripstore.proto.shared.data.source

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kr.tripstore.proto.shared.data.calendar.CalendarsDataSource
import kr.tripstore.proto.shared.data.calendar.CalendarsRepository
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.shared.test.util.assertResult
import kr.tripstore.proto.test.data.TestData
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class CalendarsRepositoryTest {

    private lateinit var calendarsRemoteDataSource: CalendarsDataSource

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        calendarsRemoteDataSource = FakeCalendarsRemoteDataSource()
    }

    @Test
    fun getCalendars_isNotNull() =
        runBlockingTest {
            val fakePlaces = arrayOf(478, 479)
            val fakeCities = arrayOf(1)
            val fakeThemes = null
            // Given a calendars data source
            val calendarsRepository =
                CalendarsRepository(
                    calendarsRemoteDataSource
                )
            // When getting a result of Calendars
            val calendarsResult =
                calendarsRepository.getCalendars(fakePlaces, fakeCities, fakeThemes)
            // Then the result is not null
            assertResult(calendarsResult)
        }

    @Test
    fun getCalendars_isSameAsTestData() =
        runBlockingTest {
            val fakePlaces = arrayOf(478, 479)
            val fakeCities = arrayOf(1)
            val fakeThemes = null
            // Given a calendars data source
            val calendarsRepository =
                CalendarsRepository(
                    calendarsRemoteDataSource
                )
            // When getting a result of Calendars
            val calendarsResult =
                calendarsRepository.getCalendars(fakePlaces, fakeCities, fakeThemes)
            val data = (calendarsResult as Result.Success).data
            // Then the data is equal to the predefined test data
            assertThat(data, IsEqual.equalTo(TestData.calendars))
        }

}