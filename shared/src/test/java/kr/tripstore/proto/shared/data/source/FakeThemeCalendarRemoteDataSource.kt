package kr.tripstore.proto.shared.data.source

import kr.tripstore.proto.model.ThemeCalendar
import kr.tripstore.proto.shared.data.themecalendar.ThemeCalendarDataSource
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.test.data.TestData

class FakeThemeCalendarRemoteDataSource : ThemeCalendarDataSource {

    override suspend fun getThemeCalendar(themeId: Int): Result<ThemeCalendar> =
        Result.Success(TestData.themeCalendar)

}