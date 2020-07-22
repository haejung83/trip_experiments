package kr.tripstore.proto.model

import com.squareup.moshi.Json

data class OverseaPackagePage(
    val time: Double,
    val error: Int,
    val errors: Any?,
    val size: Int,
    val page: Int,
    val pages: Int,
    val hasNext: Boolean,
    val total: Int,
    @field:Json(name = "list")
    val overseaPackages: List<OverseaPackage>
)

data class OverseaPackage(
    val id: Long,
    val placeId: Int,
    val departureAt: String,
    val returnAt: String,
    val airlineId: Int,
    val airlineName: String,
    @field:Json(name = "dayNightText")
    val dayAndNights: String,
    @field:Json(name = "priceFinal")
    val price: Int,
    @field:Json(name = "cityId")
    val departureCityId: Int,
    @field:Json(name = "cityName")
    val departureCityName: String,
    val imageUrl: String
)