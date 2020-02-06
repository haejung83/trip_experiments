package kr.tripstore.proto.presentation.calendar

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kr.tripstore.proto.databinding.*

abstract class CalendarItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(
        calendarItem: CalendarItem,
        calendarItemViewClickListener: CalendarItemViewClickListener
    )
}

class CalendarTitleItemViewHolder(
    private val binding: ItemCalendarTitleBinding
) : CalendarItemViewHolder(binding.root) {
    override fun bind(
        calendarItem: CalendarItem,
        calendarItemViewClickListener: CalendarItemViewClickListener
    ) {
        binding.let {
            it.item = calendarItem as CalendarTitleItem
        }
    }
}

class CalendarSpaceItemViewHolder(
    private val binding: ItemCalendarSpaceBinding
) : CalendarItemViewHolder(binding.root) {
    override fun bind(
        calendarItem: CalendarItem,
        calendarItemViewClickListener: CalendarItemViewClickListener
    ) {
        binding.let {
            it.item = calendarItem as CalendarSpaceItem
        }
    }
}

class CalendarMonthTitleItemViewHolder(
    private val binding: ItemCalendarMonthTitleBinding
) : CalendarItemViewHolder(binding.root) {
    override fun bind(
        calendarItem: CalendarItem,
        calendarItemViewClickListener: CalendarItemViewClickListener
    ) {
        binding.let {
            it.item = calendarItem as CalendarMonthTitleItem
        }
    }
}

class CalendarDayOfWeekItemViewHolder(
    private val binding: ItemCalendarDayOfWeekCellBinding
) : CalendarItemViewHolder(binding.root) {
    override fun bind(
        calendarItem: CalendarItem,
        calendarItemViewClickListener: CalendarItemViewClickListener
    ) {
        binding.let {
            it.item = calendarItem as CalendarDayOfWeekItem
        }
    }
}

class CalendarDayCellItemViewHolder(
    private val binding: ItemCalendarDayCellBinding
) : CalendarItemViewHolder(binding.root) {
    override fun bind(
        calendarItem: CalendarItem,
        calendarItemViewClickListener: CalendarItemViewClickListener
    ) {
        binding.let {
            it.item = calendarItem as CalendarDayCellItem
        }
    }
}

class CalendarEmptyCellItemViewHolder(
    private val binding: ItemCalendarEmptyBinding
) : CalendarItemViewHolder(binding.root) {
    override fun bind(
        calendarItem: CalendarItem,
        calendarItemViewClickListener: CalendarItemViewClickListener
    ) {
        binding.let {
            it.item = calendarItem as CalendarEmptyCellItem
        }
    }
}

