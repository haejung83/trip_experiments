package kr.tripstore.proto.presentation.trip.theme

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.tripstore.proto.model.domain.TripTheme
import kr.tripstore.proto.presentation.trip.TripViewModel

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
                            TripThemeCellItem(
                                tripThemeDetail.id,
                                tripThemeDetail.title,
                                tripThemeDetail.imageUrl
                            )
                        }.toTypedArray()
                    )
                }.flatten()
            )
        }
    }

}