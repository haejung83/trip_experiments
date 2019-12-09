package kr.tripstore.proto.presentation.save

import androidx.lifecycle.ViewModel
import timber.log.Timber
import javax.inject.Inject

class SaveViewModel @Inject constructor() : ViewModel() {

    fun start() {

    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared()")
    }

}