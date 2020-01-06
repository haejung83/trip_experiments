package kr.tripstore.proto.presentation.web

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient

class WebContentClient(private val delegate: WebLoadDelegate) : WebViewClient() {

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        delegate.onPageFinished(url)
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        delegate.onPageStarted(url)
    }

}