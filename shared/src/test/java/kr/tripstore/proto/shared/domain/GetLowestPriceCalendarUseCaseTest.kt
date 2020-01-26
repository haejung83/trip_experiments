package kr.tripstore.proto.shared.domain

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import kr.tripstore.proto.shared.data.calendar.CalendarsRepository
import kr.tripstore.proto.shared.data.source.FakeCalendarsRemoteDataSource
import kr.tripstore.proto.shared.data.source.FakeTemperaturesRemoteDataSource
import kr.tripstore.proto.shared.data.temperature.TemperaturesRepository
import kr.tripstore.proto.shared.domain.calendar.GetLowestPriceCalendarUseCase
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.shared.test.util.assertResult
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsNot
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class GetLowestPriceCalendarUseCaseTest {

    private lateinit var calendarsRepository: CalendarsRepository
    private lateinit var temperaturesRepository: TemperaturesRepository

    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        calendarsRepository = CalendarsRepository(FakeCalendarsRemoteDataSource())
        temperaturesRepository = TemperaturesRepository(FakeTemperaturesRemoteDataSource())
    }

    @Test
    fun getLowestPriceCalendar_isNotNull() =
        runBlocking {
            val fakePlace = 479
            val fakeCities = arrayOf(1)
            // Given repositories which getting CalendarDay and Temperatures
            val getLowestPriceCalendarUseCase = GetLowestPriceCalendarUseCase(
                calendarsRepository, temperaturesRepository
            )
            // When getting a result of LowestPriceCalendar
            val getLowestPriceCalendarResult = getLowestPriceCalendarUseCase(fakePlace, fakeCities)
            // Then the result is not null
            assertResult(getLowestPriceCalendarResult)
        }

    @Test
    fun getLowestPriceCalendar_checkResultIsNotEmpty() =
        runBlockingTest {
            val fakePlace = 479
            val fakeCities = arrayOf(1)
            // Given repositories which getting CalendarDay and Temperatures
            val getLowestPriceCalendarUseCase = GetLowestPriceCalendarUseCase(
                calendarsRepository, temperaturesRepository
            )
            // When getting a result of LowestPriceCalendar
            val getLowestPriceCalendarResult = getLowestPriceCalendarUseCase(fakePlace, fakeCities)
            val data = (getLowestPriceCalendarResult as Result.Success).data
            // Then the data is not empty
            assertThat(data.months.size, IsNot.not(0))
        }

}