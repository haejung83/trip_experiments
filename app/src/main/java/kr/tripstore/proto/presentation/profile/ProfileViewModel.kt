package kr.tripstore.proto.presentation.profile

import androidx.lifecycle.ViewModel
import timber.log.Timber
import javax.inject.Inject

class ProfileViewModel @Inject constructor() : ViewModel() {

    fun start() {

    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared()")
    }

}