package kr.tripstore.proto.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kr.tripstore.proto.shared.data.agency.AgencyRepository
import kr.tripstore.proto.shared.data.airline.AirlineRepository
import kr.tripstore.proto.shared.data.departurecity.DepartureCityRepository
import kr.tripstore.proto.shared.data.place.PlaceRepository
import kr.tripstore.proto.shared.domain.calendar.GetLowestPriceCalendarUseCase
import kr.tripstore.proto.shared.domain.themecalendar.GetLowestPriceThemeCalendarUseCase
import kr.tripstore.proto.shared.result.Result
import timber.log.Timber
import javax.inject.Inject

class ProfileViewModel @Inject constructor(
    private val getLowestPriceCalendarUseCase: GetLowestPriceCalendarUseCase,
    private val getLowestPriceThemeCalendarUseCase: GetLowestPriceThemeCalendarUseCase,
    private val agencyRepository: AgencyRepository,
    private val airlineRepository: AirlineRepository,
    private val departureCityRepository: DepartureCityRepository,
    private val placeRepository: PlaceRepository
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

            val agenciesResult = agencyRepository.getAgencies()
            if (agenciesResult is Result.Success)
                Timber.i("Agencies: $agenciesResult")

            val airlinesResult = airlineRepository.getAirlines()
            if (airlinesResult is Result.Success)
                Timber.d("Airlines: $airlinesResult")

            val departureCitiesResult = departureCityRepository.getDepartureCities()
            if (departureCitiesResult is Result.Success)
                Timber.i("DepartureCities: $departureCitiesResult")

            val placesResult = placeRepository.getPlaces(arrayOf(1))
            if (placesResult is Result.Success)
                Timber.d("Places: $placesResult")

        }
    }

    override fun onCleared() {
        super.onCleared()
        Timber.d("onCleared()")
    }

}