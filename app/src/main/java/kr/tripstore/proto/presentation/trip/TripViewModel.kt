package kr.tripstore.proto.presentation.trip

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.tripstore.proto.data.Result
import kr.tripstore.proto.domain.GetTripPackagePageUseCase
import kr.tripstore.proto.domain.GetTripThemesUseCase
import kr.tripstore.proto.domain.TripTheme
import timber.log.Timber

class TripViewModel(
    private val getTripPackagePageUseCase: GetTripPackagePageUseCase,
    private val getTripThemesUseCase: GetTripThemesUseCase
) : ViewModel() {

    private val _tripThemes = MutableLiveData<List<TripTheme>>()
    val tripThemes: LiveData<List<TripTheme>>
        get() = _tripThemes

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _isError = MutableLiveData<Boolean>(false)
    val isError: LiveData<Boolean>
        get() = _isError

    fun start() {
        viewModelScope.launch {
            _isLoading.value = true
            val tripThemesResult = getTripThemesUseCase()
            _isLoading.value = false
            if (tripThemesResult is Result.Success) {
                Timber.d("Success: $tripThemesResult")
                _tripThemes.value = tripThemesResult.data
                _isError.value = false
            } else {
                Timber.d("Error: $tripThemesResult")
                _isError.value = true
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared()")
    }

}