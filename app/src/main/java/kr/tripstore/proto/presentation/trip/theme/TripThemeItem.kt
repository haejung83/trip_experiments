package kr.tripstore.proto.presentation.trip.theme

import kr.tripstore.proto.model.TripLink

abstract class TripThemeItem(open val id: Int) {
    abstract val tripThemeType: TripThemeType
}

data class TripThemeTitleItem(
    override val id: Int,
    val title: String
) : TripThemeItem(id) {
    override val tripThemeType: TripThemeType
        get() = TripThemeType.TRIP_THEME_TITLE
}

data class TripThemeCellItem(
    override val id: Int,
    val title: String,
    val imageUrl: String,
    val openLink: TripLink,
    val openLinkSymbol: String
) :
    TripThemeItem(id) {
    override val tripThemeType: TripThemeType
        get() = TripThemeType.TRIP_THEME_CELL
}