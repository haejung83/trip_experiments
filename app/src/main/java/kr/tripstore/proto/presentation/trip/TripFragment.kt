package kr.tripstore.proto.presentation.trip

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_trip.*
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentTripBinding
import kr.tripstore.proto.extension.getViewModelFactory
import kr.tripstore.proto.presentation.base.DataBindingFragment
import kr.tripstore.proto.presentation.trip.theme.TripThemeAdapter
import kr.tripstore.proto.presentation.trip.theme.TripThemeCellItem
import kr.tripstore.proto.presentation.trip.theme.TripThemeTitleItem

class TripFragment : DataBindingFragment<FragmentTripBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_trip

    private val viewModel by viewModels<TripViewModel> { getViewModelFactory() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewModel = viewModel.apply {

        }
        viewModel.start()

        recyclerview_trip.adapter = TripThemeAdapter(viewModel).apply {
            submitList(
                listOf(
                    TripThemeTitleItem(0, "Hello"),
                    TripThemeCellItem(1, "World", ""),
                    TripThemeCellItem(2, "Free", ""),
                    TripThemeCellItem(3, "Dom", ""),
                    TripThemeCellItem(4, "Happy", ""),
                    TripThemeCellItem(5, "Coding", "")

                )
            )
        }
        recyclerview_trip.layoutManager = GridLayoutManager(context, 4, GridLayoutManager.VERTICAL, false)
    }

    companion object {
        fun newInstance() = TripFragment()
    }

}
