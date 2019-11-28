package kr.tripstore.proto.shared.network.client

import android.annotation.SuppressLint
import kr.tripstore.proto.shared.network.factory.TLSSocketFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

open class SSLHttpClientConfigurator(
    vararg interceptors: Interceptor = emptyArray(),
    isDebug: Boolean = false
) : DefaultHttpClientConfigurator(interceptors = *interceptors, isDebug = isDebug) {

    override fun configure(httpClientBuilder: OkHttpClient.Builder) {
        super.configure(httpClientBuilder)
        makeSecure(httpClientBuilder)
    }

    private fun makeSecure(httpClientBuilder: OkHttpClient.Builder) {
        try {
            SSLContext.getInstance("SSL").apply {
                init(
                    null,
                    trustAllCerts, java.security.SecureRandom()
                )
                httpClientBuilder.sslSocketFactory(
                    TLSSocketFactory(),
                    trustAllCerts[0] as X509TrustManager
                )
                httpClientBuilder.hostnameVerifier(HostnameVerifier { _, _ -> true })
            }
        } catch (t: Throwable) {
            t.printStackTrace()
        }
    }

    companion object {

        private val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            @SuppressLint("TrustAllX509TrustManager")
            override fun checkClientTrusted(
                chain: Array<java.security.cert.X509Certificate>,
                authType: String
            ) {
            }

            @SuppressLint("TrustAllX509TrustManager")
            override fun checkServerTrusted(
                chain: Array<java.security.cert.X509Certificate>,
                authType: String
            ) {
            }

            override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                return arrayOf()
            }
        })
    }

}