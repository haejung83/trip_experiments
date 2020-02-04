package kr.tripstore.proto.shared.data.themecalendar

import kr.tripstore.proto.model.ThemeCalendar
import kr.tripstore.proto.shared.result.Result

interface ThemeCalendarDataSource {

    suspend fun getThemeCalendar(themeCalendarId: Int): Result<ThemeCalendar>

}