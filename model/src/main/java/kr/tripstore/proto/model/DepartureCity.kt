package kr.tripstore.proto.model

import com.squareup.moshi.Json

data class DepartureCities(
    val time: Double,
    val error: Int,
    val errors: Any?,
    @field:Json(name = "list")
    val departureCities: List<DepartureCity>
)

data class DepartureCity(
    val id: Int,
    @field:Json(name = "cityCode")
    val departureCityCode: String,
    @field:Json(name = "cityName")
    val departureCityName: String
)