package kr.tripstore.proto.presentation.calendar

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.tripstore.proto.shared.domain.calendar.GetLowestPriceCalendarUseCase
import kr.tripstore.proto.shared.extension.empty
import kr.tripstore.proto.shared.result.Result
import timber.log.Timber
import javax.inject.Inject

class CalendarViewModel @Inject constructor(
    private val getLowestPriceCalendarUseCase: GetLowestPriceCalendarUseCase
) : ViewModel() {

    private val _placeName = MutableLiveData<String>(String.empty)
    val placeName: LiveData<String>
        get() = _placeName

    fun load(placeId: Int, cityIds: Array<Int>, themeIds: Array<Int>?) {
        viewModelScope.launch {
            Timber.v("load args: placeId[$placeId], cityIds[${cityIds.joinToString()}], themeIds[${themeIds?.joinToString()}]")
            val lowestPriceCalendarResult =
                getLowestPriceCalendarUseCase(placeId, cityIds, themeIds)
            Timber.v("lowestPriceCalendarResult: $lowestPriceCalendarResult")
            if (lowestPriceCalendarResult is Result.Success) {
                _placeName.value = lowestPriceCalendarResult.data.placeId.toString()
            }
        }
    }

}