package kr.tripstore.proto.presentation.trip.theme

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import kr.tripstore.proto.databinding.ItemThemeCellBinding
import kr.tripstore.proto.databinding.ItemThemeTitleBinding
import kr.tripstore.proto.presentation.trip.TripViewModel

class TripThemeAdapter(
    private val tripViewModel: TripViewModel
) : ListAdapter<TripThemeItem, TripThemeItemViewHolder>(TripThemeItemDiffCallback()) {

    val gridSpanSizeLookup by lazy {
        object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int =
                when (this@TripThemeAdapter.getItemViewType(position)) {
                    TripThemeType.TRIP_THEME_TITLE.viewType -> 4
                    else -> 1
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripThemeItemViewHolder =
        when (viewType) {
            TripThemeType.TRIP_THEME_TITLE.viewType ->
                TripThemeTitleItemViewHolder(
                    ItemThemeTitleBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            TripThemeType.TRIP_THEME_CELL.viewType ->
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
        holder.bind(getItem(position))

    override fun getItemViewType(position: Int): Int = getItem(position).tripThemeType.viewType

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

