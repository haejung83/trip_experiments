package kr.tripstore.proto.model.domain

import kr.tripstore.proto.model.TripLink

data class TripTheme(
    val id: Int,
    val title: String,
    val themeDetails: List<TripThemeDetail>
)

data class TripThemeDetail(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val openLink: TripLink
)