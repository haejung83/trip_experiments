package kr.tripstore.proto.model

import com.squareup.moshi.Json

data class TripPackagePage(
    val time: Double,
    val error: Int,
    val errors: Any?,
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
    private val disable: String?,
    private val isAdmin: String?
) {
    val isDisabled: Boolean
        get() = disable?.let { it == "true" } ?: false

    val isRunOnAdmin: Boolean
        get() = isAdmin?.let { it == "true" } ?: false
}

data class TripPackage(
    val id: Int,
    val title: String,
    val type: String?,
    @field:Json(name = "random")
    val isShowRandom: Boolean = false,
    @field:Json(name = "detail")
    val tripDetails: List<TripDetail> = emptyList()
)

data class TripDetail(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val subTitle: String,
    @field:Json(name = "linkUrl")
    val openLinkUrl: String
)

