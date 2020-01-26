package kr.tripstore.proto.shared.data.calendar

import kr.tripstore.proto.model.Calendars
import kr.tripstore.proto.shared.result.Result

interface CalendarsDataSource {

    suspend fun getCalendars(placeId: Array<Int>, cityId: Array<Int>): Result<Calendars>

}