package kr.tripstore.proto.presentation.web

// This is for separation between WebView and WebViewModel and for extension.
interface WebLoadDelegate {

    fun onProgressChanged(newProgress: Int)

    fun onReceivedTitle(title: String?)

    fun onPageStarted(url: String?)

    fun onPageFinished(url: String?)

}