package kr.tripstore.proto.network.client

import okhttp3.OkHttpClient

interface OkHttpClientConfigurator {

    fun configure(httpClientBuilder: OkHttpClient.Builder)

}