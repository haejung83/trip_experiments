package kr.tripstore.proto.shared.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor(
    // TODO: Get a key for authorization
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("not implemented")
    }

}