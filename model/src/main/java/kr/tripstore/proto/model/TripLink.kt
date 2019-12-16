package kr.tripstore.proto.model

data class TripLink(val type: TripLinkType, val parameters: Map<String, String?>)

enum class TripLinkType(val typeCodeName: String) {
    UNKNOWN("unknown"),
    WEB("web"),
    DETAIL("detail"),
    START("start"),
    PLACE("place"),
    CALENDAR("calendar"),
    THEME_CALENDAR("themeCalendar"),
    SEARCH("search"),
    LIST("list");

    companion object {
        fun getTripLinkTypeFromString(typeName: String) =
            with(typeName) {
                when {
                    contains(WEB.typeCodeName) -> WEB
                    contains(DETAIL.typeCodeName) -> DETAIL
                    contains(START.typeCodeName) -> START
                    contains(PLACE.typeCodeName) -> PLACE
                    contains(CALENDAR.typeCodeName) -> CALENDAR
                    contains(THEME_CALENDAR.typeCodeName) -> THEME_CALENDAR
                    contains(SEARCH.typeCodeName) -> SEARCH
                    contains(LIST.typeCodeName) -> LIST
                    else -> UNKNOWN
                }
            }
    }
}