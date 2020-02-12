package kr.tripstore.proto.model

import com.squareup.moshi.Json

data class Agencies(
    val time: Double,
    val error: Int,
    val errors: Any?,
    @field:Json(name = "list")
    val agencies: List<Agency>
)

data class Agency(
    val id: Int,
    val agencyCode: String,
    val agencyName: String,
    val contact: String,
    val counselMessage: String?,
    val itemTerms: String,
    val siteUrl: String,
    val stripJsUrl: String?
)