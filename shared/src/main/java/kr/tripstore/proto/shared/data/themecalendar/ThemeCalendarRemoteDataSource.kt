package kr.tripstore.proto.shared.data.themecalendar

import kr.tripstore.proto.model.ThemeCalendar
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject

class ThemeCalendarRemoteDataSource @Inject constructor() : ThemeCalendarDataSource {

    private val themeCalendarAPI = ThemeCalendarAPI.create()

    override suspend fun getThemeCalendar(themeId: Int): Result<ThemeCalendar> {
        val response = themeCalendarAPI.getThemeCalendar(themeId)
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.Success(it)
            } ?: Result.Error(Exception("No Data"))
        } else {
            Result.Error(Exception("Error"))
        }
    }

}