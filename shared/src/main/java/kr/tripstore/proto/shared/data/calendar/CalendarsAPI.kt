package kr.tripstore.proto.shared.data.calendar

import kr.tripstore.proto.model.Calendars
import kr.tripstore.proto.shared.BuildConfig
import kr.tripstore.proto.shared.extension.ArrayValueWrapper
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface CalendarsAPI {

    @GET("/guest/list/calendar")
    suspend fun getCalendars(
        @Query("placeId") placeIds: ArrayValueWrapper<Int>,
        @Query("cityId") cityIds: ArrayValueWrapper<Int>,
        @Query("themeId") themeIds: ArrayValueWrapper<Int>?,
        @Query("fromApp") fromApp: Boolean = true,
        @Query("platform") platform: String = "Android"
    ): Response<Calendars>

    companion object {
        fun create(): CalendarsAPI =
            Retrofit.Builder()
                .baseUrl(BuildConfig.API_HOST)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(CalendarsAPI::class.java)
    }

}