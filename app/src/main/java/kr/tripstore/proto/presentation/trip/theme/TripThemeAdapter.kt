package kr.tripstore.proto.presentation.trip.theme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import kr.tripstore.proto.databinding.ItemThemeCellBinding
import kr.tripstore.proto.databinding.ItemThemeTitleBinding

class TripThemeAdapter(
    private val tripThemeItemViewClickListener: TripThemeItemViewClickListener
) : ListAdapter<TripThemeItem, TripThemeItemViewHolder>(TripThemeItemDiffCallback()) {

    val gridSpanSizeLookup by lazy {
        object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int =
                when (this@TripThemeAdapter.getItemViewType(position)) {
                    TripThemeItemType.TRIP_THEME_TITLE.viewType -> 4
                    else -> 1
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripThemeItemViewHolder =
        when (viewType) {
            TripThemeItemType.TRIP_THEME_TITLE.viewType ->
                TripThemeTitleItemViewHolder(
                    ItemThemeTitleBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            TripThemeItemType.TRIP_THEME_CELL.viewType ->
                TripThemeCellItemViewHolder(
                    ItemThemeCellBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            else -> throw Throwable("Couldn't inflate with a given Trip Theme Type")
        }

    override fun onBindViewHolder(holder: TripThemeItemViewHolder, position: Int) =
        holder.bind(getItem(position), tripThemeItemViewClickListener)

    override fun getItemViewType(position: Int): Int = getItem(position).tripThemeItemType.viewType

}

interface TripThemeItemViewClickListener {
    fun onClick(view: View, tripThemeItem: TripThemeItem)
}

class TripThemeItemDiffCallback : DiffUtil.ItemCallback<TripThemeItem>() {

    override fun areItemsTheSame(oldItem: TripThemeItem, newItem: TripThemeItem): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: TripThemeItem, newItem: TripThemeItem): Boolean =
        if (oldItem.tripThemeItemType == newItem.tripThemeItemType) {
            when (oldItem.tripThemeItemType) {
                TripThemeItemType.TRIP_THEME_TITLE ->
                    (oldItem as TripThemeTitleItem) == (newItem as TripThemeTitleItem)
                TripThemeItemType.TRIP_THEME_CELL ->
                    (oldItem as TripThemeCellItem) == (newItem as TripThemeCellItem)
            }
        } else false

}

