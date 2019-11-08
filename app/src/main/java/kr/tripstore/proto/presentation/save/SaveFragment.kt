package kr.tripstore.proto.presentation.save

import android.os.Bundle
import androidx.fragment.app.viewModels
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.SaveFragmentBinding
import kr.tripstore.proto.extension.getViewModelFactory
import kr.tripstore.proto.presentation.base.DataBindingFragment

class SaveFragment : DataBindingFragment<SaveFragmentBinding>() {

    override val layoutResId: Int
        get() = R.layout.save_fragment

    private val viewModel by viewModels<SaveViewModel> { getViewModelFactory() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewModel = viewModel
    }

    companion object {
        fun newInstance() = SaveFragment()
    }

}
