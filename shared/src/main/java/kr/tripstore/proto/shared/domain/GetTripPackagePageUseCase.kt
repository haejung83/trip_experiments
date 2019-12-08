package kr.tripstore.proto.shared.domain

import kr.tripstore.proto.model.TripPackagePage
import kr.tripstore.proto.shared.data.Result
import kr.tripstore.proto.shared.data.source.TripRepository
import javax.inject.Inject

class GetTripPackagePageUseCase @Inject constructor(
    private val tripRepository: TripRepository
) {

    suspend operator fun invoke(): Result<TripPackagePage> =
        tripRepository.getTripPackagePage()

}