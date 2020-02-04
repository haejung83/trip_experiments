package kr.tripstore.proto.presentation.calendar

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentCalendarBinding
import kr.tripstore.proto.presentation.base.DaggerDataBindingFragment
import javax.inject.Inject

class CalendarFragment : DaggerDataBindingFragment<FragmentCalendarBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_calendar

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val args: CalendarFragmentArgs by navArgs()

    private val viewModel by viewModels<CalendarViewModel> { viewModelFactory }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.run {
            viewModel = this@CalendarFragment.viewModel
            lifecycleOwner = this@CalendarFragment
        }
        viewModel.load(args.placeId, args.cityIds.toTypedArray(), args.themeIds?.toTypedArray())
    }

}

