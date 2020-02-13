package kr.tripstore.proto.shared.data.airline

import kr.tripstore.proto.model.Airlines
import kr.tripstore.proto.shared.BuildConfig
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface AirlineAPI {

    @GET("/guest/airlines")
    suspend fun getAirlines(): Response<Airlines>

    companion object {
        fun create(): AirlineAPI =
            Retrofit.Builder()
                .baseUrl(BuildConfig.API_HOST)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(AirlineAPI::class.java)
    }

}