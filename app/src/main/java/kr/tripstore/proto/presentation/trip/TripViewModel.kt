package kr.tripstore.proto.presentation.trip

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.tripstore.proto.model.TripLink
import kr.tripstore.proto.model.domain.TripTheme
import kr.tripstore.proto.presentation.Event
import kr.tripstore.proto.presentation.trip.theme.TripThemeCellItem
import kr.tripstore.proto.presentation.trip.theme.TripThemeItem
import kr.tripstore.proto.presentation.trip.theme.TripThemeItemViewClickListener
import kr.tripstore.proto.shared.domain.trip.GetTripThemesUseCase
import kr.tripstore.proto.shared.result.Result
import timber.log.Timber
import javax.inject.Inject

class TripViewModel @Inject constructor(
    private val getTripThemesUseCase: GetTripThemesUseCase
) : ViewModel() {

    private val _tripThemes = MutableLiveData<List<TripTheme>>()
    val tripThemes: LiveData<List<TripTheme>>
        get() = _tripThemes

    private val _openTripLinkEvent = MutableLiveData<Event<TripLink>>()
    val openTripLinkEvent: LiveData<Event<TripLink>>
        get() = _openTripLinkEvent

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _isError = MutableLiveData<Boolean>(false)
    val isError: LiveData<Boolean>
        get() = _isError

    val tripThemeItemViewClickListener: TripThemeItemViewClickListener =
        object : TripThemeItemViewClickListener {
            override fun onClick(view: View, tripThemeItem: TripThemeItem) {
                when (tripThemeItem) {
                    is TripThemeCellItem -> _openTripLinkEvent.value = Event(tripThemeItem.openLink)
                }
            }
        }

    fun start() {
        if (_isLoading.value == true) return
        _isLoading.value = true

        viewModelScope.launch {
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