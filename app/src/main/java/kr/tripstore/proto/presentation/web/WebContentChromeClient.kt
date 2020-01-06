package kr.tripstore.proto.presentation.web

import android.webkit.WebChromeClient
import android.webkit.WebView

class WebContentChromeClient(private val delegate: WebLoadDelegate) : WebChromeClient() {

    override fun onReceivedTitle(view: WebView?, title: String?) {
        super.onReceivedTitle(view, title)
        delegate.onReceivedTitle(title)
    }

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
        delegate.onProgressChanged(newProgress)
    }

}