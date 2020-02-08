package kr.tripstore.proto.presentation.calendar

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.tripstore.proto.presentation.resource.DayOfWeekString
import kr.tripstore.proto.presentation.resource.DayOfWeekStringProvider
import kr.tripstore.proto.shared.domain.calendar.GetLowestPriceCalendarUseCase
import kr.tripstore.proto.shared.extension.empty
import kr.tripstore.proto.shared.result.Result
import timber.log.Timber
import java.util.*
import javax.inject.Inject

class CalendarViewModel @Inject constructor(
    private val getLowestPriceCalendarUseCase: GetLowestPriceCalendarUseCase,
    private val dayOfWeekStringProvider: DayOfWeekStringProvider
) : ViewModel() {

    private val _placeName = MutableLiveData<String>(String.empty)
    val placeName: LiveData<String>
        get() = _placeName

    private val _items = MutableLiveData<List<CalendarItem>>(emptyList())
    val items: LiveData<List<CalendarItem>>
        get() = _items

    val calendarItemViewClickListener = object : CalendarItemViewClickListener {
        override fun onClick(view: View, calendarItem: CalendarItem) {
            Timber.v("onClick: CalendarItem $calendarItem")
        }
    }

    fun load(placeId: Int, cityIds: Array<Int>, themeIds: Array<Int>?) {
        viewModelScope.launch {
            Timber.v("load args: placeId[$placeId], cityIds[${cityIds.joinToString()}], themeIds[${themeIds?.joinToString()}]")
            val lowestPriceCalendarResult =
                getLowestPriceCalendarUseCase(placeId, cityIds, themeIds)

            if (lowestPriceCalendarResult is Result.Success) {
                lowestPriceCalendarResult.data.let { data ->
                    _placeName.value = data.placeId.toString()

                    _items.value = data.years.map { year ->
                        year.months.map { month ->
                            listOf(
                                // Space (1)
                                CalendarSpaceItem(20),
                                // Month (1)
                                CalendarMonthTitleItem(
                                    month.month.toString(),
                                    month.highestTemperatures
                                ),
                                // Days of week (7)
                                *getListOfDayOfWeekItem(
                                    dayOfWeekStringProvider.daysOfWeek()
                                ).toTypedArray(),
                                // Empty (0~6)
                                *getEmptyCellItemByYearMonthDay(
                                    year.year,
                                    month.month,
                                    month.days.first().day
                                ).toTypedArray(),
                                // Days (28~31)
                                *month.days.map { day ->
                                    CalendarDayCellItem(
                                        day.day,
                                        day.price,
                                        day.gradeOfPrice,
                                        day.isHoliday
                                    )
                                }.toTypedArray(),
                                // Space (1)
                                CalendarSpaceItem(10)
                            )
                        }.flatten()
                    }.flatten()

                }
            }
        }
    }

    companion object {

        // The month is 0-based in Calendar.set(), Check below link
        // https://developer.android.com/reference/kotlin/android/icu/util/Calendar?hl=en#set_1
        private fun getEmptyCellItemByYearMonthDay(
            year: Int,
            month: Int,
            day: Int
        ): List<CalendarItem> =
            mutableListOf<CalendarEmptyCellItem>().apply {
                Calendar.getInstance(Locale.KOREA).let {
                    it.set(year, month - 1, day)
                    it.firstDayOfWeek = Calendar.SUNDAY
                    val emptyCount = it.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY
                    if (emptyCount > 0) add(CalendarEmptyCellItem(emptyCount))
                }
            }


        private fun getListOfDayOfWeekItem(daysOfWeek: List<DayOfWeekString>): List<CalendarItem> =
            daysOfWeek.map { CalendarDayOfWeekItem(it.text, it.isHoliday) }

    }

}