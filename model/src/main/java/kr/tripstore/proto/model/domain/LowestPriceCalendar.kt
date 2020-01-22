package kr.tripstore.proto.model.domain

class LowestPriceCalendar(
    val placeId: Int,
    val cityId: Int,
    val months: List<LowestPriceMonth>
)

class LowestPriceMonth(
    val month: Int,
    val highestTemperatures: String,
    val days: List<LowestPriceDay>
)

class LowestPriceDay(
    val day: Int,
    val price: Int,
    val isHoliday: Boolean
)
