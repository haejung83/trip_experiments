package kr.tripstore.proto.domain

import kr.tripstore.proto.data.Result
import kr.tripstore.proto.data.TripPackagePage
import kr.tripstore.proto.data.source.TripRepository

class GetTripPackagePageUseCase(
    private val tripRepository: TripRepository
) {

    suspend operator fun invoke(): Result<TripPackagePage> =
        tripRepository.getTripPackagePage()

}