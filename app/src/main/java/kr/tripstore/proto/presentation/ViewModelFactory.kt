package kr.tripstore.proto.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kr.tripstore.proto.shared.data.source.TripRepository
import kr.tripstore.proto.shared.domain.GetTripPackagePageUseCase
import kr.tripstore.proto.shared.domain.GetTripThemesUseCase
import kr.tripstore.proto.presentation.profile.ProfileViewModel
import kr.tripstore.proto.presentation.save.SaveViewModel
import kr.tripstore.proto.presentation.search.SearchViewModel
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
                        GetTripThemesUseCase(tripRepository)
                    )
                isAssignableFrom(ProfileViewModel::class.java) ->
                    ProfileViewModel()
                isAssignableFrom(SearchViewModel::class.java) ->
                    SearchViewModel()
                isAssignableFrom(SaveViewModel::class.java) ->
                    SaveViewModel()
                else ->
                    throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
            }
        } as T
}
