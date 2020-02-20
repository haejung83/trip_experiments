package kr.tripstore.proto.model

import com.squareup.moshi.Json

data class Places(
    val time: Double,
    val error: Int,
    val errors: Any?,
    @field:Json(name = "list")
    val places: List<Place>
)

data class Place(
    val id: Int,
    val placeCode: String,
    val placeName: String,
    val countryId: Int,
    val countryCode: String,
    val countryName: String,
    val continent: String,
    @field:Json(name = "avgFlight")
    val averageFlightTimeLabel: String,
    @field:Json(name = "disabled")
    val isDisabled: Boolean,
    @field:Json(name = "sort")
    val sortingOrder: Int,
    val synonyms: String
)
