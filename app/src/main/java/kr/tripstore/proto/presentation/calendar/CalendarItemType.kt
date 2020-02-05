package kr.tripstore.proto.presentation.calendar

enum class CalendarItemType(val viewType: Int) {
    CALENDAR_TITLE(0),
    CALENDAR_SPACE(1),
    CALENDAR_MONTH_TITLE(2),
    CALENDAR_DAY_OF_WEEK_CELL(3),
    CALENDAR_DAY_CELL(4),
    CALENDAR_EMPTY_CELL(5);
}