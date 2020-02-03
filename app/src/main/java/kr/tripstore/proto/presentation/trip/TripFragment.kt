package kr.tripstore.proto.presentation.trip

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentTripBinding
import kr.tripstore.proto.model.TripLinkType
import kr.tripstore.proto.presentation.EventObserver
import kr.tripstore.proto.presentation.base.DaggerDataBindingFragment
import timber.log.Timber
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
            Timber.d("ViewModel: ${this.hashCode()}")
        }
        setupNavigation()
        viewDataBinding.lifecycleOwner = this
        viewModel.start()
    }

    private fun setupNavigation() {
        viewModel.openTripLinkEvent.observe(
            this@TripFragment, EventObserver { tripLink ->
                Timber.d("TripLink: $tripLink")
                when (tripLink.type) {
                    TripLinkType.WEB -> {
                        navigateToWebFragment(tripLink.parameters)
                    }
                    TripLinkType.CALENDAR -> {
                        navigateToCalendarFragment(tripLink.parameters)
                    }
                    TripLinkType.THEME_CALENDAR -> {
                    }
                    else -> {
                    }
                }
            }
        )
    }

    private fun navigateToWebFragment(params: Map<String, String?>) {
        val url = params["url"]
        url?.let {
            val action =
                TripFragmentDirections.actionNavigationTripToWebFragment(it, params["title"])
            findNavController().navigate(action)
        }
    }

    private fun navigateToCalendarFragment(params: Map<String, String?>) {
        val placeId = params["placeId"]?.toInt()
        val cityIds = params["cityId"]?.let { cities ->
            cities.split(",").map { it.toInt() }
        } ?: emptyList()
        placeId?.let {
            val action = TripFragmentDirections.actionNavigationTripToCalendarFragment(
                it,
                cityIds.toIntArray()
            )
            findNavController().navigate(action)
        }
    }

}
