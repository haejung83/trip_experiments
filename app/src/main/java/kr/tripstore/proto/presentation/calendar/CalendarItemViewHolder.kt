package kr.tripstore.proto.presentation.calendar

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class CalendarItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(
        calendarItem: CalendarItem,
        calendarItemViewClickListener: CalendarItemViewClickListener
    )
}






