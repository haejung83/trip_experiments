package kr.tripstore.proto.presentation.search

import androidx.lifecycle.ViewModel
import timber.log.Timber
import javax.inject.Inject

class SearchViewModel @Inject constructor(): ViewModel() {

    fun start() {

    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared()")
    }

}