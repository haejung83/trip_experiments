package kr.tripstore.proto.model.domain

import java.util.*

data class LowestPriceThemeCalendar(
    val placeId: Int,
    val cityId: Array<Int>,
    val months: List<LowestPriceMonth>,
    val description: LowestPriceThemeCalendarDescription
)

data class LowestPriceThemeCalendarDescription(
    val id: Int,
    val title: String,
    val subTitle: String,
    val description: String,
    val imageUrl: String,
    val createdAt: Date?,
    val updatedAt: Date?
)