package kr.tripstore.proto.presentation.calendar

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.*
import kr.tripstore.proto.model.domain.PriceGrade
import kr.tripstore.proto.shared.extension.empty

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
            it.executePendingBindings()
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
            it.executePendingBindings()
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
            it.executePendingBindings()
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
            it.executePendingBindings()
        }
    }
}

class CalendarDayCellItemViewHolder(
    private val binding: ItemCalendarDayCellBinding
) : CalendarItemViewHolder(binding.root) {

    private val tenThousandWon: String
    private val colorExpensive: Int
    private val colorReasonable: Int
    private val colorCheap: Int

    init {
        binding.root.context.run {
            tenThousandWon = getString(R.string.calendar_ten_thousand_won)
            colorExpensive = ContextCompat.getColor(this, R.color.ts_calendar_expensive)
            colorReasonable = ContextCompat.getColor(this, R.color.ts_calendar_reasonable)
            colorCheap = ContextCompat.getColor(this, R.color.ts_calendar_cheap)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun bind(
        calendarItem: CalendarItem,
        calendarItemViewClickListener: CalendarItemViewClickListener
    ) {
        binding.let {
            if (calendarItem is CalendarDayCellItem) {
                it.item = calendarItem
                it.textviewPrice.text =
                    if (calendarItem.lowestPrice >= TEN_THOUSAND)
                        "${calendarItem.lowestPrice / TEN_THOUSAND}${tenThousandWon}"
                    else String.empty
                it.textviewPrice.setTextColor(
                    when (calendarItem.gradeOfPrice) {
                        PriceGrade.EXPENSIVE -> colorExpensive
                        PriceGrade.REASONABLE -> colorReasonable
                        PriceGrade.CHEAP -> colorCheap
                        else -> Color.TRANSPARENT
                    }
                )
                it.executePendingBindings()
            }
        }
    }

    companion object {
        private const val TEN_THOUSAND = 10000
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
            it.executePendingBindings()
        }
    }
}

