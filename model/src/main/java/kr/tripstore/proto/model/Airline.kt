package kr.tripstore.proto.model

import com.squareup.moshi.Json

data class Airlines(
    val time: Double,
    val error: Int,
    val errors: Any?,
    @field:Json(name = "list")
    val airlines: List<Airline>
)

data class Airline(
    val id: Int,
    val airlineCode: String,
    val airlineName: String
)