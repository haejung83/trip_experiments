package kr.tripstore.proto.shared.data.trip

import kr.tripstore.proto.model.TripPackagePage
import kr.tripstore.proto.shared.BuildConfig
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface TripPackagePageAPI {

    @GET("/guest/main/contents?fromApp=true&platform=Android&shown=true")
    suspend fun getTripPackagePage(): Response<TripPackagePage>

    companion object {
        fun create(): TripPackagePageAPI =
            Retrofit.Builder()
                .baseUrl(BuildConfig.API_HOST)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(TripPackagePageAPI::class.java)
    }

}