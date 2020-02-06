package kr.tripstore.proto.presentation.calendar

import kr.tripstore.proto.model.domain.PriceGrade

abstract class CalendarItem {
    abstract val calendarItemType: CalendarItemType
}

data class CalendarTitleItem(
    val title: String
) : CalendarItem() {
    override val calendarItemType: CalendarItemType
        get() = CalendarItemType.CALENDAR_TITLE
}

data class CalendarSpaceItem(
    val height: Int
) : CalendarItem() {
    override val calendarItemType: CalendarItemType
        get() = CalendarItemType.CALENDAR_SPACE
}

data class CalendarMonthTitleItem(
    val monthTitle: String,
    val highestTemperature: String
) : CalendarItem() {
    override val calendarItemType: CalendarItemType
        get() = CalendarItemType.CALENDAR_MONTH_TITLE
}

data class CalendarDayOfWeekItem(
    val dayOfWeek: String,
    val isHoliday: Boolean
) : CalendarItem() {
    override val calendarItemType: CalendarItemType
        get() = CalendarItemType.CALENDAR_DAY_OF_WEEK_CELL
}

data class CalendarDayCellItem(
    val day: Int,
    val lowestPrice: Int,
    val gradeOfPrice: PriceGrade,
    val isHoliday: Boolean
) : CalendarItem() {
    override val calendarItemType: CalendarItemType
        get() = CalendarItemType.CALENDAR_DAY_CELL
}

data class CalendarEmptyCellItem(
    val emptyCellCount: Int
) : CalendarItem() {
    override val calendarItemType: CalendarItemType
        get() = CalendarItemType.CALENDAR_EMPTY_CELL
}
