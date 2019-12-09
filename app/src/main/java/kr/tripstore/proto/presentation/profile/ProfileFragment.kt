package kr.tripstore.proto.presentation.profile

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentProfileBinding
import kr.tripstore.proto.presentation.base.DaggerDataBindingFragment
import timber.log.Timber
import javax.inject.Inject

class ProfileFragment : DaggerDataBindingFragment<FragmentProfileBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_profile

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<ProfileViewModel> { viewModelFactory }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewModel = viewModel.apply {
            Timber.d("ViewModel: ${this.hashCode()}")
        }
        viewDataBinding.lifecycleOwner = this
        viewModel.start()
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }

}
