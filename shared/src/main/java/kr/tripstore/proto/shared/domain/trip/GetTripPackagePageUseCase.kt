package kr.tripstore.proto.shared.domain.trip

import kr.tripstore.proto.model.TripPackagePage
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.shared.data.trip.TripRepository
import javax.inject.Inject

class GetTripPackagePageUseCase @Inject constructor(
    private val tripRepository: TripRepository
) {

    suspend operator fun invoke(): Result<TripPackagePage> =
        tripRepository.getTripPackagePage()

}