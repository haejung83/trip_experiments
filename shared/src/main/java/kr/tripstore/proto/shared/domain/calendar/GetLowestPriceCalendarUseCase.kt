package kr.tripstore.proto.shared.domain.calendar

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

    suspend operator fun invoke(placeId: Int, cityId: Int): Result<LowestPriceCalendar> {
        val calendars = calendarsRepository.getCalendars(placeId, cityId)
        val temperatures = temperaturesRepository.getTemperatures(placeId)
        val extractRegex = REGEXP_YEAR_MONTH_DAY.toRegex()

        return when (calendars) {
            is Result.Success -> {
                Result.Success(
                    LowestPriceCalendar(placeId, cityId,
                        calendars.data.calendarDays.mapNotNull { calendarDay ->
                            extractRegex.find(calendarDay.date)
                                ?.groupValues?.let { extractedDateGroup ->
                                Triple(
                                    // Year
                                    extractedDateGroup[1].toInt(),
                                    // Month
                                    extractedDateGroup[2].toInt(),
                                    LowestPriceDay(
                                        // Day
                                        extractedDateGroup[3].toInt(),
                                        calendarDay.price,
                                        calendarDay.isHoliday
                                    )
                                )
                            }
                        }.groupBy {
                            it.second
                        }.map { groupedLowestPriceDay ->
                            LowestPriceMonth(
                                groupedLowestPriceDay.key,
                                String.empty,
                                groupedLowestPriceDay.value.map { it.third })
                        }
                    )
                )
            }
            is Result.Error -> Result.Error(calendars.exception)
            is Result.Loading -> Result.Loading
        }
    }

    companion object {
        private const val REGEXP_YEAR_MONTH_DAY =
            "(20\\d{2})[-]*(0[1-9]|1[012])[-]*(0[1-9]|[12][0-9]|3[01])"
    }

}