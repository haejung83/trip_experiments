package kr.tripstore.proto.shared.network.client

import okhttp3.OkHttpClient

interface OkHttpClientConfigurator {

    fun configure(httpClientBuilder: OkHttpClient.Builder)

}