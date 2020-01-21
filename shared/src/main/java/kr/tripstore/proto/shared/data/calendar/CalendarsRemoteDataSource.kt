package kr.tripstore.proto.shared.data.calendar

import kr.tripstore.proto.model.Calendars
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject

class CalendarsRemoteDataSource @Inject constructor() : CalendarsDataSource {

    private val calendarsAPI = CalendarsAPI.create()

    override suspend fun getCalendars(placeId: Int, cityId: Int): Result<Calendars> {
        val response = calendarsAPI.getCalendars(placeId, cityId)
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.Success(it)
            } ?: Result.Error(Exception("No Data"))
        } else {
            Result.Error(Exception("Error"))
        }
    }

}
