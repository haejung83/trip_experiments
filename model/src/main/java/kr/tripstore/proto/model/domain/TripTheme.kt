package kr.tripstore.proto.model.domain

data class TripTheme(
    val id: Int,
    val title: String,
    val themeDetails: List<TripThemeDetail>
)

data class TripThemeDetail(
    val id: Int,
    val title: String,
    val imageUrl: String,
    val openLinkUrl: String
)