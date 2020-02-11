package kr.tripstore.proto.shared.domain.calendar

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kr.tripstore.proto.model.CalendarDay
import kr.tripstore.proto.model.domain.*
import kr.tripstore.proto.shared.data.calendar.CalendarsRepository
import kr.tripstore.proto.shared.data.temperature.TemperaturesRepository
import kr.tripstore.proto.shared.di.DefaultCoroutineDispatcher
import kr.tripstore.proto.shared.extension.empty
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject

class GetLowestPriceCalendarUseCase @Inject constructor(
    private val calendarsRepository: CalendarsRepository,
    private val temperaturesRepository: TemperaturesRepository,
    @DefaultCoroutineDispatcher private val defaultDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(
        placeId: Int,
        cityIds: Array<Int>,
        themeIds: Array<Int>? = null
    ): Result<LowestPriceCalendar> = withContext(defaultDispatcher) {
        // Prepare high temperatures
        val highTemperatures =
            when (val temperatures = temperaturesRepository.getTemperatures(placeId)) {
                is Result.Success -> {
                    temperatures.data.highTemperatures.let { if (it.isNotEmpty()) it else null }
                }
                else -> null
            }

        // Assemble a LowestPriceCalendar using the Calendar result and prepared high temperatures
        when (val calendars =
            calendarsRepository.getCalendars(arrayOf(placeId), cityIds, themeIds)) {
            is Result.Success -> {
                Result.Success(
                    LowestPriceCalendar(
                        placeId,
                        cityIds,
                        themeIds,
                        assembleLowestPriceYearsUsingCalendarDays(
                            calendars.data.calendarDays,
                            highTemperatures
                        )
                    )
                )
            }
            is Result.Error -> Result.Error(Exception("GetLowestPriceCalendarUseCase: Error"))
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

        private fun findMinMaxPriceFromCalendarDays(calendarDays: List<CalendarDay>): Pair<Int, Int> =
            Pair(
                calendarDays.minBy { it.price }?.price ?: 0,
                calendarDays.maxBy { it.price }?.price ?: 10_000_000
            )

        private fun getLowerAndUpperBaseForGradeOfPrice(min: Int, max: Int): Pair<Int, Int> {
            val oneThird = (max - min) / 3
            val twiceOfOneThird = oneThird * 2
            return Pair(oneThird + min, twiceOfOneThird + min)
        }

        private fun assembleLowestPriceYearsUsingCalendarDays(
            calendarDays: List<CalendarDay>,
            highTemperatures: List<String>?
        ): List<LowestPriceYear> {
            val (min, max) = findMinMaxPriceFromCalendarDays(calendarDays)
            val (lower, upper) = getLowerAndUpperBaseForGradeOfPrice(min, max)

            return calendarDays.mapNotNull { calendarDay ->
                REGEXP_YEAR_MONTH_DAY.find(calendarDay.date)?.let { matched ->
                    Triple(
                        matched.groupValues[INDEX_YEAR].toInt(),
                        matched.groupValues[INDEX_MONTH].toInt(),
                        LowestPriceDay(
                            matched.groupValues[INDEX_DAY].toInt(),
                            calendarDay.price,
                            when (calendarDay.price) {
                                in upper until max -> PriceGrade.EXPENSIVE
                                in lower until upper -> PriceGrade.REASONABLE
                                in min until lower -> PriceGrade.CHEAP
                                else -> PriceGrade.NONE
                            },
                            calendarDay.isHoliday
                        )
                    )
                }
            }.groupBy {
                it.first // GroupBy Year
            }.map { yearGroupedLowestPriceDay ->
                LowestPriceYear(
                    yearGroupedLowestPriceDay.key,
                    yearGroupedLowestPriceDay.value
                        .groupBy {
                            it.second // GroupBy Month
                        }.map { monthGroupedLowestPriceDay ->
                            LowestPriceMonth(
                                monthGroupedLowestPriceDay.key,
                                highTemperatures?.get(monthGroupedLowestPriceDay.key - 1)
                                    ?: String.empty,
                                monthGroupedLowestPriceDay.value.map { it.third })
                        }
                )
            }
        }

    }

}