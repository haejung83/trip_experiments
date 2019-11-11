package kr.tripstore.proto.network.client

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import java.util.concurrent.TimeUnit

open class DefaultHttpClientConfigurator(
    private vararg val interceptors: Interceptor,
    isDebug: Boolean
) : OkHttpClientConfigurator {

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (isDebug) Level.BODY else Level.NONE
    }

    override fun configure(httpClientBuilder: OkHttpClient.Builder) {
        httpClientBuilder
            .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .let {
                for (interceptor in interceptors)
                    it.addInterceptor(interceptor)
            }
    }

    companion object {
        private const val HTTP_READ_TIMEOUT = 60L
        private const val HTTP_CONNECT_TIMEOUT = 30L
    }

}