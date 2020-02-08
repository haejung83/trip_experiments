package kr.tripstore.proto.presentation.calendar

import android.widget.FrameLayout
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

object CalendarBindings {

    @BindingAdapter("heightOfSpace")
    @JvmStatic
    fun setHeightOfSpace(frameLayout: FrameLayout, heightOfSpace: Int?) {
        heightOfSpace?.let {
            frameLayout.layoutParams.height = heightOfSpace
        }
    }

    @BindingAdapter("viewModel")
    @JvmStatic
    fun setAdapterWithViewModel(recyclerView: RecyclerView, viewModel: CalendarViewModel) {
        recyclerView.run {
            setHasFixedSize(true)
            val calendarAdapter = CalendarAdapter(viewModel.calendarItemViewClickListener)
            adapter = calendarAdapter
            layoutManager = GridLayoutManager(context, 7, GridLayoutManager.VERTICAL, false)
                .apply {
                    spanSizeLookup = calendarAdapter.gridSpanSizeLookup
                }
        }
    }

    @BindingAdapter("items")
    @JvmStatic
    fun setCalendarItems(recyclerView: RecyclerView, items: List<CalendarItem>?) {
        items?.let { calendarItems ->
            (recyclerView.adapter as? CalendarAdapter)?.submitList(calendarItems)
            // FIXME: It's for smooth scrolling. Do think and make more graceful it.
            recyclerView.setItemViewCacheSize(calendarItems.size)
        }
    }

}