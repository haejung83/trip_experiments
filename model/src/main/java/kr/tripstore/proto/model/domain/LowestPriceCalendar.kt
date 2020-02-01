package kr.tripstore.proto.model.domain

data class LowestPriceCalendar(
    val placeId: Int,
    val cityId: Array<Int>,
    val months: List<LowestPriceMonth>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LowestPriceCalendar

        if (placeId != other.placeId) return false
        if (!cityId.contentEquals(other.cityId)) return false
        if (months != other.months) return false

        return true
    }

    override fun hashCode(): Int {
        var result = placeId
        result = 31 * result + cityId.contentHashCode()
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
