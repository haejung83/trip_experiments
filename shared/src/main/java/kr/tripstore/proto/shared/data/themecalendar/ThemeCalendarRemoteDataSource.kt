package kr.tripstore.proto.shared.data.themecalendar

import kr.tripstore.proto.model.ThemeCalendar
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject

class ThemeCalendarRemoteDataSource @Inject constructor() : ThemeCalendarDataSource {

    private val themeCalendarAPI = ThemeCalendarAPI.create()

    override suspend fun getThemeCalendar(themeCalendarId: Int): Result<ThemeCalendar> {
        val response = themeCalendarAPI.getThemeCalendar(themeCalendarId)
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.Success(it)
            } ?: Result.Error(Exception("ThemeCalendarRemoteDataSource: is not available"))
        } else {
            Result.Error(Exception("ThemeCalendarRemoteDataSource: Error"))
        }
    }

}