package kr.tripstore.proto.shared.data.source

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kr.tripstore.proto.shared.data.themecalendar.ThemeCalendarDataSource
import kr.tripstore.proto.shared.data.themecalendar.ThemeCalendarRepository
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.shared.test.util.assertResult
import kr.tripstore.proto.test.data.TestData
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ThemeCalendarRepositoryTest {

    private lateinit var themeCalendarsRemoteDataSource: ThemeCalendarDataSource

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        themeCalendarsRemoteDataSource = FakeThemeCalendarRemoteDataSource()
    }

    @Test
    fun getThemeCalendar_isNotNull() =
        runBlockingTest {
            val fakeThemeCalendarId = 116
            // Given a theme calendar data source
            val themeCalendarRepository =
                ThemeCalendarRepository(
                    themeCalendarsRemoteDataSource
                )
            // When getting a result of ThemeCalendar
            val themeCalendarResult = themeCalendarRepository.getThemeCalendar(fakeThemeCalendarId)
            // Then the result is  not null
            assertResult(themeCalendarResult)
        }

    @Test
    fun getThemeCalendar_isSameAsTestData() =
        runBlockingTest {
            val fakeThemeCalendarId = 116
            // Given a theme calendar data source
            val themeCalendarRepository =
                ThemeCalendarRepository(
                    themeCalendarsRemoteDataSource
                )
            // When getting a result of ThemeCalendar
            val themeCalendarResult = themeCalendarRepository.getThemeCalendar(fakeThemeCalendarId)
            val data = (themeCalendarResult as Result.Success).data
            // Then the data is equal to the predefined test data
            assertThat(data, IsEqual.equalTo(TestData.themeCalendar))
        }

}