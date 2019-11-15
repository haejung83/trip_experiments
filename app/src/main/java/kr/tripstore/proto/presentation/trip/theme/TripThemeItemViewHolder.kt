package kr.tripstore.proto.presentation.trip.theme

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kr.tripstore.proto.databinding.ItemThemeCellBinding
import kr.tripstore.proto.databinding.ItemThemeTitleBinding

abstract class TripThemeItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(tripThemeItem: TripThemeItem)
}

class TripThemeTitleItemViewHolder(private val binding: ItemThemeTitleBinding) :
    TripThemeItemViewHolder(binding.root) {
    override fun bind(tripThemeItem: TripThemeItem) {
        binding.let {
            it.item = tripThemeItem as TripThemeTitleItem
        }
    }
}

class TripThemeCellItemViewHolder(private val binding: ItemThemeCellBinding) :
    TripThemeItemViewHolder(binding.root) {
    override fun bind(tripThemeItem: TripThemeItem) {
        binding.let {
            it.item = tripThemeItem as TripThemeCellItem
        }
    }
}