package kr.tripstore.proto.presentation.trip

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import kr.tripstore.proto.data.Result
import kr.tripstore.proto.domain.GetTripPackagePageUseCase
import timber.log.Timber

class TripViewModel(
    private val getTripPackagePageUseCase: GetTripPackagePageUseCase
) : ViewModel() {

    fun start() {
        viewModelScope.launch {
            val tripPackagePageResult = getTripPackagePageUseCase()
            if (tripPackagePageResult is Result.Success) {
                Timber.d("Success: $tripPackagePageResult")
            } else {
                Timber.d("Error: $tripPackagePageResult")
            }
        }
    }



}