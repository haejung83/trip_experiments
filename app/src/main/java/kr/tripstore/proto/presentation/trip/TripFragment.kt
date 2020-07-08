package kr.tripstore.proto.presentation.trip

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentTripBinding
import kr.tripstore.proto.model.TripLinkType
import kr.tripstore.proto.presentation.EventObserver
import kr.tripstore.proto.presentation.base.DataBindingFragment
import kr.tripstore.proto.shared.extension.splitAndGetIntArrayByComma
import timber.log.Timber

@AndroidEntryPoint
class TripFragment : DataBindingFragment<FragmentTripBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_trip

    private val viewModel: TripViewModel by viewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewModel = viewModel.apply {
            Timber.d("ViewModel: ${this.hashCode()}")
        }
        setupNavigation()
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        viewModel.start()
    }

    private fun setupNavigation() {
        viewModel.openTripLinkEvent.observe(
            viewLifecycleOwner, EventObserver { tripLink ->
                Timber.d("TripLink: $tripLink")
                when (tripLink.type) {
                    TripLinkType.WEB -> {
                        navigateToWebFragment(tripLink.parameters)
                    }
                    TripLinkType.CALENDAR -> {
                        navigateToCalendarFragment(tripLink.parameters)
                    }
                    TripLinkType.THEME_CALENDAR -> {
                        // FIXME: Use a normal calendar UI for temporary
                        navigateToCalendarFragment(tripLink.parameters)
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
        val placeIds = params["placeId"]?.splitAndGetIntArrayByComma()?.filter { it != 0 }
        val cityIds = params["cityId"]?.splitAndGetIntArrayByComma() ?: emptyList()
        val themeIds = params["themeId"]?.splitAndGetIntArrayByComma()
        placeIds?.first()?.let {
            val action = TripFragmentDirections.actionNavigationTripToCalendarFragment(
                it,
                cityIds.toIntArray(),
                themeIds?.toIntArray()
            )
            findNavController().navigate(action)
        }
    }

}
