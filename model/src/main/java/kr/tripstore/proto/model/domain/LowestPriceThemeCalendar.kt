package kr.tripstore.proto.model.domain

import java.util.*

data class LowestPriceThemeCalendar(
    val themeId: Int,
    val placeId: Int,
    val cityId: Array<Int>,
    val months: List<LowestPriceMonth>,
    val description: LowestPriceThemeCalendarDescription
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LowestPriceThemeCalendar

        if (themeId != other.themeId) return false
        if (placeId != other.placeId) return false
        if (!cityId.contentEquals(other.cityId)) return false
        if (months != other.months) return false
        if (description != other.description) return false

        return true
    }

    override fun hashCode(): Int {
        var result = themeId
        result = 31 * result + placeId
        result = 31 * result + cityId.contentHashCode()
        result = 31 * result + months.hashCode()
        result = 31 * result + description.hashCode()
        return result
    }
}

data class LowestPriceThemeCalendarDescription(
    val id: Int,
    val title: String,
    val subTitle: String,
    val description: String,
    val imageUrl: String,
    val createdAt: Date?,
    val updatedAt: Date?
)