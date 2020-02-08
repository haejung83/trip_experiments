package kr.tripstore.proto.presentation.calendar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import kr.tripstore.proto.databinding.*

class CalendarAdapter(
    private val calendarItemViewClickListener: CalendarItemViewClickListener
) : ListAdapter<CalendarItem, CalendarItemViewHolder>(CalendarItemDiffCallback()) {

    val gridSpanSizeLookup by lazy {
        object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int =
                when (this@CalendarAdapter.getItemViewType(position)) {
                    CalendarItemType.CALENDAR_DAY_CELL.viewType -> 1
                    CalendarItemType.CALENDAR_EMPTY_CELL.viewType -> 1
                    CalendarItemType.CALENDAR_DAY_OF_WEEK_CELL.viewType -> 1
                    CalendarItemType.CALENDAR_MONTH_TITLE.viewType -> 7
                    CalendarItemType.CALENDAR_SPACE.viewType -> 7
                    CalendarItemType.CALENDAR_TITLE.viewType -> 7
                    else -> 1
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarItemViewHolder =
        when (viewType) {
            CalendarItemType.CALENDAR_DAY_CELL.viewType ->
                CalendarDayCellItemViewHolder(
                    ItemCalendarDayCellBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            CalendarItemType.CALENDAR_EMPTY_CELL.viewType ->
                CalendarEmptyCellItemViewHolder(
                    ItemCalendarEmptyBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            CalendarItemType.CALENDAR_DAY_OF_WEEK_CELL.viewType ->
                CalendarDayOfWeekItemViewHolder(
                    ItemCalendarDayOfWeekCellBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            CalendarItemType.CALENDAR_MONTH_TITLE.viewType ->
                CalendarMonthTitleItemViewHolder(
                    ItemCalendarMonthTitleBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            CalendarItemType.CALENDAR_SPACE.viewType ->
                CalendarSpaceItemViewHolder(
                    ItemCalendarSpaceBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            CalendarItemType.CALENDAR_TITLE.viewType ->
                CalendarTitleItemViewHolder(
                    ItemCalendarTitleBinding.inflate(
                        LayoutInflater.from(parent.context), parent, false
                    )
                )
            else -> throw Throwable("Couldn't inflate with a given CalendarItemType")
        }

    override fun onBindViewHolder(holder: CalendarItemViewHolder, position: Int) =
        holder.bind(getItem(position), calendarItemViewClickListener)

    override fun getItemViewType(position: Int): Int = getItem(position).calendarItemType.viewType

}

interface CalendarItemViewClickListener {
    fun onClick(view: View, calendarItem: CalendarItem)
}

class CalendarItemDiffCallback : DiffUtil.ItemCallback<CalendarItem>() {

    override fun areItemsTheSame(oldItem: CalendarItem, newItem: CalendarItem): Boolean =
        oldItem.hashCode() == newItem.hashCode()

    override fun areContentsTheSame(oldItem: CalendarItem, newItem: CalendarItem): Boolean =
        if (oldItem.calendarItemType == newItem.calendarItemType) {
            when (oldItem.calendarItemType) {
                CalendarItemType.CALENDAR_DAY_CELL ->
                    (oldItem as CalendarDayCellItem) == (newItem as CalendarDayCellItem)
                CalendarItemType.CALENDAR_EMPTY_CELL ->
                    (oldItem as CalendarEmptyCellItem) == (newItem as CalendarEmptyCellItem)
                CalendarItemType.CALENDAR_DAY_OF_WEEK_CELL ->
                    (oldItem as CalendarDayOfWeekItem) == (newItem as CalendarDayOfWeekItem)
                CalendarItemType.CALENDAR_MONTH_TITLE ->
                    (oldItem as CalendarMonthTitleItem) == (newItem as CalendarMonthTitleItem)
                CalendarItemType.CALENDAR_SPACE ->
                    (oldItem as CalendarSpaceItem) == (newItem as CalendarSpaceItem)
                CalendarItemType.CALENDAR_TITLE ->
                    (oldItem as CalendarTitleItem) == (newItem as CalendarTitleItem)
            }
        } else {
            false
        }

}