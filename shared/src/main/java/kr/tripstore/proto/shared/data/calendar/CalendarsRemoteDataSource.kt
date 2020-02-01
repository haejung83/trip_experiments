package kr.tripstore.proto.shared.data.calendar

import kr.tripstore.proto.model.Calendars
import kr.tripstore.proto.shared.extension.toArrayValueWrapper
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject

class CalendarsRemoteDataSource @Inject constructor() : CalendarsDataSource {

    private val calendarsAPI = CalendarsAPI.create()

    override suspend fun getCalendars(
        placeIds: Array<Int>,
        cityIds: Array<Int>
    ): Result<Calendars> {
        val response =
            calendarsAPI.getCalendars(placeIds.toArrayValueWrapper(), cityIds.toArrayValueWrapper())
        return if (response.isSuccessful) {
            response.body()?.let {
                Result.Success(it)
            } ?: Result.Error(Exception("CalendarsRemoteDataSource: is not available"))
        } else {
            Result.Error(Exception("CalendarsRemoteDataSource: Error"))
        }
    }

}
