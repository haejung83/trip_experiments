package kr.tripstore.proto.shared.data.themecalendar

import kr.tripstore.proto.model.ThemeCalendar
import kr.tripstore.proto.shared.BuildConfig
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ThemeCalendarAPI {

    @GET("/guest/themeCalendars/{themeCalendarId}")
    suspend fun getThemeCalendar(@Path("themeCalendarId") themeCalendarId: Int): Response<ThemeCalendar>

    companion object {
        fun create(): ThemeCalendarAPI =
            Retrofit.Builder()
                .baseUrl(BuildConfig.API_HOST)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(ThemeCalendarAPI::class.java)
    }

}