package kr.tripstore.proto.shared.data.calendar

import kr.tripstore.proto.model.Calendars
import kr.tripstore.proto.shared.result.Result

interface CalendarsDataSource {

    suspend fun getCalendars(
        placeIds: Array<Int>,
        cityIds: Array<Int>,
        themeIds: Array<Int>? = null
    ): Result<Calendars>

}