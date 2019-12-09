package kr.tripstore.proto.presentation.save

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentSaveBinding
import kr.tripstore.proto.presentation.base.DaggerDataBindingFragment
import timber.log.Timber
import javax.inject.Inject

class SaveFragment : DaggerDataBindingFragment<FragmentSaveBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_save

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<SaveViewModel> { viewModelFactory }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewModel = viewModel.apply {
            Timber.d("ViewModel: ${this.hashCode()}")
        }
        viewDataBinding.lifecycleOwner = this
        viewModel.start()
    }

    companion object {
        fun newInstance() = SaveFragment()
    }

}
