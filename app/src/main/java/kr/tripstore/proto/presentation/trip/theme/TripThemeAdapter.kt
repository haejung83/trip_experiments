package kr.tripstore.proto.presentation.trip.theme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.tripstore.proto.R
import kr.tripstore.proto.presentation.trip.TripViewModel

enum class TripThemeType(val viewType: Int) {
    TRIP_THEME_TITLE(0),
    TRIP_THEME_CELL(1);
}

class TripThemeAdapter(
    private val tripViewModel: TripViewModel
) : ListAdapter<TripThemeItem, TripThemeItemViewHolder>(TripThemeItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripThemeItemViewHolder =
        when (viewType) {
            TripThemeType.TRIP_THEME_TITLE.viewType ->
                TripThemeTitleItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_theme_title,
                        parent,
                        false
                    )
                )
            TripThemeType.TRIP_THEME_CELL.viewType ->
                TripThemeCellItemViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        R.layout.item_theme_cell,
                        parent,
                        false
                    )
                )
            else -> throw Throwable("Couldn't inflate with a given Trip Theme Type")
        }

    override fun onBindViewHolder(holder: TripThemeItemViewHolder, position: Int) =
        holder.bind(getItem(position))

    override fun getItemViewType(position: Int): Int = getItem(position).tripThemeType.viewType
}

abstract class TripThemeItem(open val id: Int) {

    abstract val tripThemeType: TripThemeType

}

data class TripThemeTitleItem(override val id: Int, val title: String) : TripThemeItem(id) {
    override val tripThemeType: TripThemeType
        get() = TripThemeType.TRIP_THEME_TITLE
}

data class TripThemeCellItem(override val id: Int, val title: String, val imageUrl: String) :
    TripThemeItem(id) {
    override val tripThemeType: TripThemeType
        get() = TripThemeType.TRIP_THEME_CELL
}

abstract class TripThemeItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(tripThemeItem: TripThemeItem)
}

class TripThemeTitleItemViewHolder(view: View) : TripThemeItemViewHolder(view) {

    override fun bind(tripThemeItem: TripThemeItem) {
        itemView.findViewById<TextView>(R.id.textview_theme_title).text =
            (tripThemeItem as TripThemeTitleItem).title
    }
}

class TripThemeCellItemViewHolder(view: View) : TripThemeItemViewHolder(view) {
    override fun bind(tripThemeItem: TripThemeItem) {
        itemView.findViewById<TextView>(R.id.textview_theme_cell).text =
            (tripThemeItem as TripThemeCellItem).title
    }
}

class TripThemeItemDiffCallback : DiffUtil.ItemCallback<TripThemeItem>() {
    override fun areItemsTheSame(oldItem: TripThemeItem, newItem: TripThemeItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: TripThemeItem, newItem: TripThemeItem): Boolean =
        if (oldItem.tripThemeType == newItem.tripThemeType) {
            when (oldItem.tripThemeType) {
                TripThemeType.TRIP_THEME_TITLE ->
                    (oldItem as TripThemeTitleItem) == (newItem as TripThemeTitleItem)
                TripThemeType.TRIP_THEME_CELL ->
                    (oldItem as TripThemeCellItem) == (newItem as TripThemeCellItem)
            }
        } else false

}
