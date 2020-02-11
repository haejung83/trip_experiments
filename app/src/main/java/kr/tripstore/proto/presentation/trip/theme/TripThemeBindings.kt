package kr.tripstore.proto.presentation.trip.theme

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kr.tripstore.proto.presentation.trip.TripViewModel

object TripThemeBindings {

    @BindingAdapter("viewModel")
    @JvmStatic
    fun setAdapterWithViewModel(recyclerView: RecyclerView, viewModel: TripViewModel) {
        recyclerView.run {
            val tripThemeAdapter = TripThemeAdapter(viewModel.tripThemeItemViewClickListener)
            adapter = tripThemeAdapter
            layoutManager = GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false).apply {
                spanSizeLookup = tripThemeAdapter.gridSpanSizeLookup
            }
        }
    }

    @BindingAdapter("tripThemeItems")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items: List<TripThemeItem>?) {
        items?.let {
            (recyclerView.adapter as? TripThemeAdapter)?.submitList(it)
            recyclerView.scheduleLayoutAnimation()
        }
    }

}