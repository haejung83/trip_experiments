package kr.tripstore.proto.data

import com.squareup.moshi.Json

data class TripPackagePage(
    val time: Double,
    val error: Int,
    val errors: String,
    val size: Int,
    val page: Int,
    val pages: Int,
    val hasNext: Boolean,
    val total: Int,
    val filter: TripPackagePageFilter,
    @field:Json(name = "list")
    val tripPackages: List<TripPackage>
)

data class TripPackagePageFilter(
    val disable: Boolean?,
    val isAdmin: Boolean?
)

data class TripPackage(
    val id: Int,
    val title: String?,
    val type: String?,
    @field:Json(name = "random")
    val isShowRandom: Boolean?,
    @field:Json(name = "detail")
    val tripDetails: List<TripDetail>?
)

data class TripDetail(
    val id: Int,
    val title: String?,
    val imageUrl: String?,
    val subTitle: String?
)

