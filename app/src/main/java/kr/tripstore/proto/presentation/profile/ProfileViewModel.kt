package kr.tripstore.proto.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.tripstore.proto.shared.domain.calendar.GetLowestPriceCalendarUseCase
import kr.tripstore.proto.shared.domain.themecalendar.GetLowestPriceThemeCalendarUseCase
import kr.tripstore.proto.shared.result.Result
import timber.log.Timber
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val getLowestPriceCalendarUseCase: GetLowestPriceCalendarUseCase,
    private val getLowestPriceThemeCalendarUseCase: GetLowestPriceThemeCalendarUseCase
) : ViewModel() {

    fun start() {
        // FIXME: For Testing
        viewModelScope.launch {
            val lowestPriceCalendarResult = getLowestPriceCalendarUseCase(479, arrayOf(1, 2))
            if (lowestPriceCalendarResult is Result.Success)
                Timber.d("LowestPriceCalendar: $lowestPriceCalendarResult")

            val lowestPriceThemeCalendarResult =
                getLowestPriceThemeCalendarUseCase(116, 9296, arrayOf(1))
            if (lowestPriceThemeCalendarResult is Result.Success)
                Timber.d("LowestPriceThemeCalendar: $lowestPriceThemeCalendarResult")
        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared()")
    }

}