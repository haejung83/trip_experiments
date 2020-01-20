package kr.tripstore.proto.model

import com.squareup.moshi.Json

data class Temperatures(
    val time: Double,
    val error: Int,
    val errors: Any?,
    @field:Json(name = "item")
    val highTemperatures: List<String>
)