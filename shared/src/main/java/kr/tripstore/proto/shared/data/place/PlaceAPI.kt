package kr.tripstore.proto.shared.data.place

import kr.tripstore.proto.model.Places
import kr.tripstore.proto.shared.BuildConfig
import kr.tripstore.proto.shared.extension.ArrayValueWrapper
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface PlaceAPI {

    @GET("/guest/list/places")
    suspend fun getPlaces(
        @Query("cityId") departureCityIds: ArrayValueWrapper<Int>,
        @Query("fromApp") fromApp: Boolean = true,
        @Query("platform") platform: String = "Android"
    ): Response<Places>

    companion object {
        fun create(): PlaceAPI =
            Retrofit.Builder()
                .baseUrl(BuildConfig.API_HOST)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(PlaceAPI::class.java)
    }

}