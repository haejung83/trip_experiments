package kr.tripstore.proto.shared.domain.themecalendar

import kr.tripstore.proto.model.ThemeCalendarDescription
import kr.tripstore.proto.model.domain.LowestPriceThemeCalendar
import kr.tripstore.proto.model.domain.LowestPriceThemeCalendarDescription
import kr.tripstore.proto.shared.data.themecalendar.ThemeCalendarRepository
import kr.tripstore.proto.shared.domain.calendar.GetLowestPriceCalendarUseCase
import kr.tripstore.proto.shared.result.Result
import kr.tripstore.proto.shared.util.themeCalendarDateFormat
import javax.inject.Inject

class GetLowestPriceThemeCalendarUseCase @Inject constructor(
    private val getLowestPriceCalendarUseCase: GetLowestPriceCalendarUseCase,
    private val themeCalendarRepository: ThemeCalendarRepository
) {

    suspend operator fun invoke(
        themeCalendarId: Int,
        placeId: Int,
        cityIds: Array<Int>
    ): Result<LowestPriceThemeCalendar> {

        val themeDescription =
            when (val themeCalendar = themeCalendarRepository.getThemeCalendar(themeCalendarId)) {
                is Result.Success -> themeCalendar.data.description
                else -> null
            }

        return when (val lowestPriceCalendar = getLowestPriceCalendarUseCase(placeId, cityIds)) {
            is Result.Success -> {
                themeDescription?.let { description ->
                    Result.Success(
                        LowestPriceThemeCalendar(
                            themeCalendarId,
                            placeId,
                            cityIds,
                            lowestPriceCalendar.data.years,
                            getLowestPriceThemeCalendarDescriptionFromThemeCalendarDescription(
                                description
                            )
                        )
                    )
                } ?: Result.Error(
                    Exception("GetLowestPriceThemeCalendarUseCase: is not available")
                )
            }
            is Result.Error -> Result.Error(Exception("GetLowestPriceThemeCalendarUseCase: Error"))
            is Result.Loading -> Result.Loading
        }
    }

    companion object {

        private fun getLowestPriceThemeCalendarDescriptionFromThemeCalendarDescription(
            themeCalendarDescription: ThemeCalendarDescription
        ) = themeCalendarDescription.run {
            LowestPriceThemeCalendarDescription(
                id,
                title,
                subTitle,
                description,
                imageUrl,
                createdAt?.let { themeCalendarDateFormat.parse(it) },
                updatedAt?.let { themeCalendarDateFormat.parse(it) }
            )
        }
    }

}