package kr.tripstore.proto.shared.data.temperature

import kr.tripstore.proto.model.Temperatures
import kr.tripstore.proto.shared.BuildConfig
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TemperaturesAPI {

    @GET("/guest/places/{placeId}/temperature")
    suspend fun getTemperatures(
        @Path("placeId") placeId: Int,
        @Query("fromApp") fromApp: Boolean = true
    ): Response<Temperatures>

    companion object {
        fun create(): TemperaturesAPI =
            Retrofit.Builder()
                .baseUrl(BuildConfig.API_HOST)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(TemperaturesAPI::class.java)
    }

}