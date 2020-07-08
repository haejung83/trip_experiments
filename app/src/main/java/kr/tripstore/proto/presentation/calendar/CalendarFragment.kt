package kr.tripstore.proto.presentation.calendar

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentCalendarBinding
import kr.tripstore.proto.presentation.base.DataBindingFragment

@AndroidEntryPoint
class CalendarFragment : DataBindingFragment<FragmentCalendarBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_calendar

    private val args: CalendarFragmentArgs by navArgs()

    private val viewModel: CalendarViewModel by viewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.run {
            viewModel = this@CalendarFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        viewModel.load(args.placeId, args.cityIds.toTypedArray(), args.themeIds?.toTypedArray())
    }

}

