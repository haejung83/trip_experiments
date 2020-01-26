package kr.tripstore.proto.shared.data.source

import kr.tripstore.proto.model.Calendars
import kr.tripstore.proto.shared.data.calendar.CalendarsDataSource
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.test.data.TestData

class FakeCalendarsRemoteDataSource : CalendarsDataSource {

    override suspend fun getCalendars(placeId: Array<Int>, cityId: Array<Int>): Result<Calendars> =
        Result.Success(TestData.calendars)

}