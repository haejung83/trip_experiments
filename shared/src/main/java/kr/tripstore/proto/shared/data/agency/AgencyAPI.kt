package kr.tripstore.proto.shared.data.agency

import kr.tripstore.proto.model.Agencies
import kr.tripstore.proto.shared.BuildConfig
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface AgencyAPI {

    @GET("/guest/agencies")
    suspend fun getAgencies(): Response<Agencies>

    companion object {
        fun create(): AgencyAPI =
            Retrofit.Builder()
                .baseUrl(BuildConfig.API_HOST)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(AgencyAPI::class.java)
    }

}