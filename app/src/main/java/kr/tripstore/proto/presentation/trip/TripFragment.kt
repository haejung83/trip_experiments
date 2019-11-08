package kr.tripstore.proto.presentation.trip

import android.os.Bundle
import androidx.fragment.app.viewModels
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.TripFragmentBinding
import kr.tripstore.proto.extension.getViewModelFactory
import kr.tripstore.proto.presentation.base.DataBindingFragment

class TripFragment : DataBindingFragment<TripFragmentBinding>() {

    override val layoutResId: Int
        get() = R.layout.trip_fragment

    private val viewModel by viewModels<TripViewModel> { getViewModelFactory() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewModel = viewModel
        viewModel.start()
    }

    companion object {
        fun newInstance() = TripFragment()
    }

}
