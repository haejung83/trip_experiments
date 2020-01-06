package kr.tripstore.proto.presentation.web

import android.webkit.WebView
import androidx.databinding.BindingAdapter

object WebViewBindings {

    @BindingAdapter("loadUrl")
    @JvmStatic
    fun setLoadUrl(webView: WebView, loadUrl: String?) {
        loadUrl?.let {
            webView.loadUrl(it)
        }
    }

}