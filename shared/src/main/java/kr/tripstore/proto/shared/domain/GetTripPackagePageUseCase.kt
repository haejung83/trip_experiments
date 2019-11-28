package kr.tripstore.proto.shared.domain

import kr.tripstore.proto.model.TripPackagePage
import kr.tripstore.proto.shared.data.Result
import kr.tripstore.proto.shared.data.source.TripRepository

class GetTripPackagePageUseCase(
    private val tripRepository: TripRepository
) {

    suspend operator fun invoke(): Result<TripPackagePage> =
        tripRepository.getTripPackagePage()

}