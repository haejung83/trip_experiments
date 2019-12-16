package kr.tripstore.proto.shared.domain

import android.net.Uri
import kr.tripstore.proto.model.TripLink
import kr.tripstore.proto.model.TripLinkType
import kr.tripstore.proto.model.domain.TripTheme
import kr.tripstore.proto.model.domain.TripThemeDetail
import kr.tripstore.proto.shared.data.Result
import kr.tripstore.proto.shared.data.source.TripRepository
import javax.inject.Inject

class GetTripThemesUseCase @Inject constructor(
    private val tripRepository: TripRepository
) {

    suspend operator fun invoke(): Result<List<TripTheme>> =
        when (val tripPackagePage = tripRepository.getTripPackagePage()) {
            is Result.Success -> {
                Result.Success(
                    tripPackagePage.data.tripPackages
                        .filter { it.title.isNotEmpty() && it.tripDetails.isNotEmpty() }
                        .map { tripPackage ->
                            TripTheme(
                                tripPackage.id,
                                tripPackage.title,
                                tripPackage.tripDetails
                                    .filter { it.title.isNotEmpty() && it.imageUrl.isNotEmpty() && it.openLinkUrl.isNotEmpty() }
                                    .map { tripDetail ->
                                        TripThemeDetail(
                                            tripDetail.id,
                                            tripDetail.title,
                                            tripDetail.imageUrl,
                                            parseOpenLinkUrlToTripLink(tripDetail.openLinkUrl)
                                        )
                                    }
                            )
                        }
                )
            }
            is Result.Error -> Result.Error(tripPackagePage.exception)
            is Result.Loading -> Result.Loading
        }

    private fun parseOpenLinkUrlToTripLink(openLink: String): TripLink {
        val parsedUri = Uri.parse(openLink)
        val type = parsedUri.path?.let {
            TripLinkType.getTripLinkTypeFromString(it)
        } ?: TripLinkType.UNKNOWN
        val parameters = parsedUri.queryParameterNames.associateWithTo(
            mutableMapOf(), { parsedUri.getQueryParameter(it) }
        )
        return TripLink(type, parameters)
    }

}