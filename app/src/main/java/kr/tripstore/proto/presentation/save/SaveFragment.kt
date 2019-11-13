package kr.tripstore.proto.presentation.save

import android.os.Bundle
import androidx.fragment.app.viewModels
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentSaveBinding
import kr.tripstore.proto.extension.getViewModelFactory
import kr.tripstore.proto.presentation.base.DataBindingFragment

class SaveFragment : DataBindingFragment<FragmentSaveBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_save

    private val viewModel by viewModels<SaveViewModel> { getViewModelFactory() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewModel = viewModel
    }

    companion object {
        fun newInstance() = SaveFragment()
    }

}
