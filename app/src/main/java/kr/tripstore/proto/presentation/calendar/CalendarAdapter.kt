package kr.tripstore.proto.presentation.calendar

import android.view.View

class CalendarAdapter {

}

interface CalendarItemViewClickListener {
    fun onClick(view: View, calendarItem: CalendarItem)
}