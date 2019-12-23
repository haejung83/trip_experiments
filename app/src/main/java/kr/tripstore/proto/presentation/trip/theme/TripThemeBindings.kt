package kr.tripstore.proto.presentation.trip.theme

import android.content.Context
import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.tripstore.proto.R
import kr.tripstore.proto.model.TripLinkType
import kr.tripstore.proto.model.domain.TripTheme
import kr.tripstore.proto.presentation.trip.TripViewModel
import kr.tripstore.proto.shared.extension.empty

object TripThemeBindings {

    @BindingAdapter("viewModel")
    @JvmStatic
    fun setAdapterWithViewModel(recyclerView: RecyclerView, viewModel: TripViewModel) {
        recyclerView.run {
            val tripThemeAdapter = TripThemeAdapter(viewModel)
            adapter = tripThemeAdapter
            layoutManager = GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false).apply {
                spanSizeLookup = tripThemeAdapter.gridSpanSizeLookup
            }
        }
    }

    @BindingAdapter("items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items: List<TripTheme>?) {
        items?.let { tripThemes ->
            (recyclerView.adapter as? TripThemeAdapter)?.submitList(
                tripThemes.map { tripTheme ->
                    listOf(
                        TripThemeTitleItem(
                            tripTheme.id,
                            tripTheme.title
                        ),
                        *tripTheme.themeDetails.map { tripThemeDetail ->
                            val openLinkSymbol = getSymbolFromOpenLink(
                                recyclerView.context,
                                tripThemeDetail.openLink.type
                            )
                            TripThemeCellItem(
                                tripThemeDetail.id,
                                tripThemeDetail.title,
                                tripThemeDetail.imageUrl,
                                openLinkSymbol,
                                if (openLinkSymbol.isNotEmpty()) View.VISIBLE else View.INVISIBLE
                            )
                        }.toTypedArray()
                    )
                }.flatten()
            )
        }
    }

    private fun getSymbolFromOpenLink(context: Context, typeOfLink: TripLinkType): String {
        return when (typeOfLink) {
            TripLinkType.WEB -> context.getString(R.string.trip_detail_symbol_of_web)
            TripLinkType.DETAIL -> context.getString(R.string.trip_detail_symbol_of_detail)
            TripLinkType.START -> context.getString(R.string.trip_detail_symbol_of_start)
            TripLinkType.PLACE -> context.getString(R.string.trip_detail_symbol_of_place)
            TripLinkType.CALENDAR -> context.getString(R.string.trip_detail_symbol_of_calendar)
            TripLinkType.THEME_CALENDAR -> context.getString(R.string.trip_detail_symbol_of_theme_calendar)
            TripLinkType.SEARCH -> context.getString(R.string.trip_detail_symbol_of_search)
            TripLinkType.LIST -> context.getString(R.string.trip_detail_symbol_of_list)
            else -> String.empty
        }
    }

}