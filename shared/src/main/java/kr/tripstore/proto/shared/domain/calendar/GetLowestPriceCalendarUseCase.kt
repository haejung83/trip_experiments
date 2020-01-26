package kr.tripstore.proto.shared.domain.calendar

import kr.tripstore.proto.model.CalendarDay
import kr.tripstore.proto.model.domain.LowestPriceCalendar
import kr.tripstore.proto.model.domain.LowestPriceDay
import kr.tripstore.proto.model.domain.LowestPriceMonth
import kr.tripstore.proto.shared.data.calendar.CalendarsRepository
import kr.tripstore.proto.shared.data.temperature.TemperaturesRepository
import kr.tripstore.proto.shared.extension.empty
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject

class GetLowestPriceCalendarUseCase @Inject constructor(
    private val calendarsRepository: CalendarsRepository,
    private val temperaturesRepository: TemperaturesRepository
) {

    suspend operator fun invoke(
        placeId: Int,
        cityId: Array<Int>
    ): Result<LowestPriceCalendar> {
        // Prepare high temperatures
        val highTemperatures =
            when (val temperatures = temperaturesRepository.getTemperatures(placeId)) {
                is Result.Success -> {
                    temperatures.data.highTemperatures.let { if (it.isNotEmpty()) it else null }
                }
                else -> null
            }

        // Assemble a LowestPriceCalendar using the Calendar result and prepared high temperatures
        return when (val calendars = calendarsRepository.getCalendars(arrayOf(placeId), cityId)) {
            is Result.Success -> {
                Result.Success(
                    LowestPriceCalendar(
                        placeId,
                        cityId,
                        assembleLowestPriceMonthsUsingCalendarsDays(
                            calendars.data.calendarDays,
                            highTemperatures
                        )
                    )
                )
            }
            is Result.Error -> Result.Error(calendars.exception)
            is Result.Loading -> Result.Loading
        }
    }

    companion object {
        @Suppress("unused")
        private const val INDEX_ALL = 0
        private const val INDEX_YEAR = 1
        private const val INDEX_MONTH = 2
        private const val INDEX_DAY = 3
        private val REGEXP_YEAR_MONTH_DAY =
            "(20\\d{2})[-]*(0[1-9]|1[012])[-]*(0[1-9]|[12][0-9]|3[01])".toRegex()

        private fun assembleLowestPriceMonthsUsingCalendarsDays(
            calendarDays: List<CalendarDay>,
            highTemperatures: List<String>?
        ) = calendarDays.mapNotNull { calendarDay ->
            REGEXP_YEAR_MONTH_DAY.find(calendarDay.date)?.let { matched ->
                Triple(
                    matched.groupValues[INDEX_YEAR].toInt(),
                    matched.groupValues[INDEX_MONTH].toInt(),
                    LowestPriceDay(
                        matched.groupValues[INDEX_DAY].toInt(),
                        calendarDay.price,
                        calendarDay.isHoliday
                    )
                )
            }
        }.groupBy {
            it.second // GroupBy Month
        }.map { groupedLowestPriceDay ->
            LowestPriceMonth(
                groupedLowestPriceDay.key,
                highTemperatures?.get(groupedLowestPriceDay.key - 1) ?: String.empty,
                groupedLowestPriceDay.value.map { it.third })
        }
    }

}