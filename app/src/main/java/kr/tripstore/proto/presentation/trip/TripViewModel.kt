package kr.tripstore.proto.presentation.trip

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.tripstore.proto.model.TripLink
import kr.tripstore.proto.model.domain.TripTheme
import kr.tripstore.proto.presentation.Event
import kr.tripstore.proto.presentation.resource.TripLinkSymbolStringProvider
import kr.tripstore.proto.presentation.trip.theme.TripThemeCellItem
import kr.tripstore.proto.presentation.trip.theme.TripThemeItem
import kr.tripstore.proto.presentation.trip.theme.TripThemeItemViewClickListener
import kr.tripstore.proto.presentation.trip.theme.TripThemeTitleItem
import kr.tripstore.proto.shared.domain.trip.GetTripThemesUseCase
import kr.tripstore.proto.shared.extension.empty
import kr.tripstore.proto.shared.result.Result
import timber.log.Timber

class TripViewModel @ViewModelInject constructor(
    private val getTripThemesUseCase: GetTripThemesUseCase,
    private val tripLinkSymbolStringProvider: TripLinkSymbolStringProvider
) : ViewModel() {

    private val _tripThemeItems = MutableLiveData<List<TripThemeItem>>()
    val tripThemeItems: LiveData<List<TripThemeItem>>
        get() = _tripThemeItems

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
        loadTripThemes()
    }

    private fun loadTripThemes() {
        if (_isLoading.value == true) return
        _isLoading.value = true

        viewModelScope.launch {
            val tripThemesResult = getTripThemesUseCase()
            _isLoading.value = false
            if (tripThemesResult is Result.Success) {
                Timber.d("Success: $tripThemesResult")
                _tripThemeItems.value = getTripThemeItemsFromTripThemes(tripThemesResult.data)
                _isError.value = false
            } else {
                Timber.d("Error: $tripThemesResult")
                _isError.value = true
            }
        }
    }

    private suspend fun getTripThemeItemsFromTripThemes(tripThemes: List<TripTheme>): List<TripThemeItem> =
        withContext(Dispatchers.Default) {
            tripThemes.map { tripTheme ->
                listOf(
                    TripThemeTitleItem(
                        tripTheme.id,
                        tripTheme.title
                    ),
                    *tripTheme.themeDetails.map { tripThemeDetail ->
                        tripThemeDetail.run {
                            TripThemeCellItem(
                                id,
                                title,
                                imageUrl,
                                openLink,
                                tripLinkSymbolStringProvider.getSymbolByTripLinkType(
                                    openLink.type
                                ) ?: String.empty
                            )
                        }
                    }.toTypedArray()
                )
            }.flatten()
        }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared()")
    }

}