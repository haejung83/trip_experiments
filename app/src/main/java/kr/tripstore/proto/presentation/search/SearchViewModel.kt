package kr.tripstore.proto.presentation.search

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.tripstore.proto.shared.domain.trip.GetTripPackagePageUseCase
import kr.tripstore.proto.shared.result.Result
import timber.log.Timber

class SearchViewModel @ViewModelInject constructor(
    private val getTripPackagePageUseCase: GetTripPackagePageUseCase
) : ViewModel() {

    private val _displayCount = MutableLiveData<String>("")
    val displayCount: LiveData<String>
        get() = _displayCount

    fun start() {
        viewModelScope.launch {
            val tripPackagePageResult = getTripPackagePageUseCase()

            if (tripPackagePageResult is Result.Success) {
                Timber.d("Success: $tripPackagePageResult")
                _displayCount.value = tripPackagePageResult.data.size.toString()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared()")
    }

}