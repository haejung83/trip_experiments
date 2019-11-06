package kr.tripstore.proto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.tripstore.proto.data.source.TripRepository
import kr.tripstore.proto.domain.GetTripPackagePageUseCase
import kr.tripstore.proto.presentation.trip.TripViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory constructor(
    private val tripRepository: TripRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>) =
        with(modelClass) {
            when {
                isAssignableFrom(TripViewModel::class.java) ->
                    TripViewModel(
                        GetTripPackagePageUseCase(tripRepository)
                    )
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}
