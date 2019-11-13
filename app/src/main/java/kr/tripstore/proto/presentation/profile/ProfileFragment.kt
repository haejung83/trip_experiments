package kr.tripstore.proto.presentation.profile

import android.os.Bundle
import androidx.fragment.app.viewModels
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentProfileBinding
import kr.tripstore.proto.extension.getViewModelFactory
import kr.tripstore.proto.presentation.base.DataBindingFragment

class ProfileFragment : DataBindingFragment<FragmentProfileBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_profile

    private val viewModel by viewModels<ProfileViewModel> { getViewModelFactory() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewModel = viewModel
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }

}
