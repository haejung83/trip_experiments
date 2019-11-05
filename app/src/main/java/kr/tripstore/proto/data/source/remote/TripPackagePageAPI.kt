package kr.tripstore.proto.data.source.remote

import kr.tripstore.proto.data.TripPackagePage
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface TripPackagePageAPI {

    @GET("/guest/main/contents")
    suspend fun getTripPackagePage(): Response<TripPackagePage>

    companion object {
        private const val BASE_URL = "https://api.tripstore.kr"

        fun create() =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(TripPackagePageAPI::class.java)
    }

}