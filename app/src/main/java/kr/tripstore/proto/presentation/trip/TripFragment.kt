package kr.tripstore.proto.presentation.trip

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentTripBinding
import kr.tripstore.proto.extension.getViewModelFactory
import kr.tripstore.proto.presentation.base.DaggerDataBindingFragment
import kr.tripstore.proto.presentation.base.DataBindingFragment
import javax.inject.Inject

class TripFragment : DaggerDataBindingFragment<FragmentTripBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_trip

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<TripViewModel> { viewModelFactory }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewModel = viewModel.apply {
        }
        viewModel.start()
    }

    companion object {
        fun newInstance() = TripFragment()
    }

}
