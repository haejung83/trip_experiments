package kr.tripstore.proto.shared.data.departurecity

import kr.tripstore.proto.model.DepartureCities
import kr.tripstore.proto.shared.BuildConfig
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface DepartureCityAPI {

    @GET("/guest/cities/startable")
    suspend fun getCities(): Response<DepartureCities>

    companion object {
        fun create(): DepartureCityAPI =
            Retrofit.Builder()
                .baseUrl(BuildConfig.API_HOST)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(DepartureCityAPI::class.java)
    }

}