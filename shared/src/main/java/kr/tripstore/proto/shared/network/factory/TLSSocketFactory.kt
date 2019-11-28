package kr.tripstore.proto.shared.network.factory

import java.net.InetAddress
import java.net.Socket
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocket
import javax.net.ssl.SSLSocketFactory

class TLSSocketFactory : SSLSocketFactory() {

    private var sslSocketFactory: SSLSocketFactory = SSLContext.getInstance("TLS").apply {
        init(null, null, null)
    }.socketFactory

    override fun getDefaultCipherSuites(): Array<String> = sslSocketFactory.defaultCipherSuites

    override fun getSupportedCipherSuites(): Array<String> = sslSocketFactory.supportedCipherSuites

    override fun createSocket(s: Socket?, host: String?, port: Int, autoClose: Boolean): Socket =
        enableTLSOnSocket(
            sslSocketFactory.createSocket(s, host, port, autoClose)
        )

    override fun createSocket(host: String?, port: Int): Socket =
        enableTLSOnSocket(
            sslSocketFactory.createSocket(host, port)
        )

    override fun createSocket(
        host: String?,
        port: Int,
        localHost: InetAddress?,
        localPort: Int
    ): Socket =
        enableTLSOnSocket(
            sslSocketFactory.createSocket(host, port, localHost, localPort)
        )

    override fun createSocket(host: InetAddress?, port: Int): Socket =
        enableTLSOnSocket(
            sslSocketFactory.createSocket(host, port)
        )

    override fun createSocket(
        address: InetAddress?,
        port: Int,
        localAddress: InetAddress?,
        localPort: Int
    ): Socket =
        enableTLSOnSocket(
            sslSocketFactory.createSocket(address, port, localAddress, localPort)
        )

    private fun enableTLSOnSocket(socket: Socket): Socket =
        socket.apply {
            if (socket is SSLSocket) socket.enabledProtocols = arrayOf("TLSv1.1", "TLSv1.2")
        }

}