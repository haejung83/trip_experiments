package kr.tripstore.proto.presentation.web

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kr.tripstore.proto.shared.extension.empty
import timber.log.Timber
import javax.inject.Inject

class WebViewModel @Inject constructor() : ViewModel(), WebLoadDelegate {

    private val _pageTitle = MutableLiveData<String>(String.empty)
    val pageTitle: LiveData<String>
        get() = _pageTitle

    private val _loadingProgress = MutableLiveData<Int>(0)
    val loadingProgress: LiveData<Int>
        get() = _loadingProgress

    private val _isLoadingProgressVisible = MutableLiveData<Boolean>(false)
    val isLoadingProgressVisible: LiveData<Boolean>
        get() = _isLoadingProgressVisible

    private val _loadUrl = MutableLiveData<String>(String.empty)
    val loadUrl: LiveData<String>
        get() = _loadUrl

    fun load(url: String) {
        _loadUrl.value = url
    }

    override fun onProgressChanged(newProgress: Int) {
        _loadingProgress.value = newProgress
    }

    override fun onReceivedTitle(title: String?) {
        title?.let { _pageTitle.value = it }
    }

    override fun onPageStarted(url: String?) {
        _isLoadingProgressVisible.value = true
    }

    override fun onPageFinished(url: String?) {
        _isLoadingProgressVisible.value = false
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared()")
    }
}