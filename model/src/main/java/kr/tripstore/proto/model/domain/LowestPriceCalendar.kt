package kr.tripstore.proto.model.domain

data class LowestPriceCalendar(
    val placeId: Int,
    val cityIds: Array<Int>,
    val themeIds: Array<Int>?,
    val months: List<LowestPriceMonth>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LowestPriceCalendar

        if (placeId != other.placeId) return false
        if (!cityIds.contentEquals(other.cityIds)) return false
        if (themeIds != null) {
            if (other.themeIds == null) return false
            if (!themeIds.contentEquals(other.themeIds)) return false
        } else if (other.themeIds != null) return false
        if (months != other.months) return false

        return true
    }

    override fun hashCode(): Int {
        var result = placeId
        result = 31 * result + cityIds.contentHashCode()
        result = 31 * result + (themeIds?.contentHashCode() ?: 0)
        result = 31 * result + months.hashCode()
        return result
    }
}

data class LowestPriceMonth(
    val month: Int,
    val highestTemperatures: String,
    val days: List<LowestPriceDay>
)

data class LowestPriceDay(
    val day: Int,
    val price: Int,
    val isHoliday: Boolean
)
