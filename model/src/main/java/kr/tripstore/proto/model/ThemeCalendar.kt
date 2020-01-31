package kr.tripstore.proto.model

import com.squareup.moshi.Json

data class ThemeCalendar(
    val time: Double,
    val error: Int,
    val errors: Any?,
    @field:Json(name = "item")
    val description: ThemeCalendarDescription
)

data class ThemeCalendarDescription(
    val id: Int,
    val title: String,
    val subTitle: String,
    val description: String,
    val imageUrl: String,
    val createdAt: String?,
    val updatedAt: String?
)