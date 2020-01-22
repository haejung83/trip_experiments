package kr.tripstore.proto.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.tripstore.proto.shared.domain.calendar.GetLowestPriceCalendarUseCase
import timber.log.Timber
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val getLowestPriceCalendarUseCase: GetLowestPriceCalendarUseCase
) : ViewModel() {

    fun start() {
        viewModelScope.launch {
            val lowestPriceCalendar = getLowestPriceCalendarUseCase(479, 1)
            Timber.d("LowestPriceCalendar: $lowestPriceCalendar")
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared()")
    }

}