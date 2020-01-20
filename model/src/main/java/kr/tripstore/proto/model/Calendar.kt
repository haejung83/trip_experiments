package kr.tripstore.proto.model

import com.squareup.moshi.Json

data class Calendars(
    val time: Double,
    val error: Int,
    val errors: Any?,
    @field:Json(name = "list")
    val calendarDays: List<CalendarDay>
)

data class CalendarDay(
    val date: String,
    val price: Int,
    @field:Json(name = "holiday")
    val isHoliday: Boolean
)