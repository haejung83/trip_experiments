package kr.tripstore.proto.shared.domain.trip

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kr.tripstore.proto.model.TripPackagePage
import kr.tripstore.proto.shared.data.trip.TripRepository
import kr.tripstore.proto.shared.di.DefaultCoroutineDispatcher
import kr.tripstore.proto.shared.result.Result
import javax.inject.Inject

class GetTripPackagePageUseCase @Inject constructor(
    private val tripRepository: TripRepository,
    @DefaultCoroutineDispatcher private val defaultDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Result<TripPackagePage> = withContext(defaultDispatcher) {
        tripRepository.getTripPackagePage()
    }

}