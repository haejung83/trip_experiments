package kr.tripstore.proto.data

import com.squareup.moshi.Json
import kr.tripstore.proto.extension.empty

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
    private val disable: String = String.empty,
    private val isAdmin: String = String.empty
) {
    val isDisabled: Boolean
        get() = disable == "true"

    val isRunOnAdmin: Boolean
        get() = isAdmin == "true"
}

data class TripPackage(
    val id: Int,
    val title: String = String.empty,
    val type: String = String.empty,
    @field:Json(name = "random")
    val isShowRandom: Boolean = false,
    @field:Json(name = "detail")
    val tripDetails: List<TripDetail> = emptyList()
)

data class TripDetail(
    val id: Int,
    val title: String = String.empty,
    val imageUrl: String = String.empty,
    val subTitle: String = String.empty,
    @field:Json(name = "linkUrl")
    val openLinkUrl: String = String.empty
)

