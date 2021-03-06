package kr.tripstore.proto.presentation.resource

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ActivityScoped
import kr.tripstore.proto.R
import kr.tripstore.proto.model.TripLinkType
import javax.inject.Inject

interface TripLinkSymbolStringProvider {
    fun getSymbolByTripLinkType(tripLinkType: TripLinkType): String?
}

@ActivityScoped
class ContextTripLinkSymbolStringProvider @Inject constructor(
    @ApplicationContext context: Context
) : TripLinkSymbolStringProvider {

    private val cached: Map<TripLinkType, String> = mapOf(
        TripLinkType.WEB to context.getString(R.string.trip_link_symbol_of_web),
        TripLinkType.DETAIL to context.getString(R.string.trip_link_symbol_of_detail),
        TripLinkType.START to context.getString(R.string.trip_link_symbol_of_start),
        TripLinkType.PLACE to context.getString(R.string.trip_link_symbol_of_place),
        TripLinkType.CALENDAR to context.getString(R.string.trip_link_symbol_of_calendar),
        TripLinkType.THEME_CALENDAR to context.getString(R.string.trip_link_symbol_of_theme_calendar),
        TripLinkType.SEARCH to context.getString(R.string.trip_link_symbol_of_search),
        TripLinkType.LIST to context.getString(R.string.trip_link_symbol_of_list)
    )

    override fun getSymbolByTripLinkType(tripLinkType: TripLinkType): String? =
        cached[tripLinkType]

}