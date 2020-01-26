package kr.tripstore.proto.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.tripstore.proto.shared.domain.calendar.GetLowestPriceCalendarUseCase
import kr.tripstore.proto.shared.result.Result
import timber.log.Timber
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val getLowestPriceCalendarUseCase: GetLowestPriceCalendarUseCase
) : ViewModel() {

    fun start() {
        // FIXME: For Testing
        viewModelScope.launch {
            val lowestPriceCalendarResult = getLowestPriceCalendarUseCase(479, arrayOf(1, 2))
            if (lowestPriceCalendarResult is Result.Success)
                Timber.d("LowestPriceCalendar: $lowestPriceCalendarResult")
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared()")
    }

}