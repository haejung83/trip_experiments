package kr.tripstore.proto.network.client

import kr.tripstore.proto.BuildConfig
import okhttp3.OkHttpClient

class OkHttpClientBuilderFactory {
    private val okHttpClient by lazy(LazyThreadSafetyMode.NONE) {
        OkHttpClient()
    }

    private val defaultHttpClientConfigurator by lazy(LazyThreadSafetyMode.NONE) {
        DefaultHttpClientConfigurator(isDebug = BuildConfig.DEBUG)
    }

    fun create(configurator: OkHttpClientConfigurator? = null): OkHttpClient.Builder =
        okHttpClient.newBuilder().apply {
            configurator?.configure(this)
                ?: defaultHttpClientConfigurator.configure(this)
        }

    companion object {
        private var instance: OkHttpClientBuilderFactory? = null

        fun getInstance() =
            instance
                ?: synchronized(this) {
                    instance
                        ?: OkHttpClientBuilderFactory().apply {
                            instance = this
                        }
                }
    }
}