package kr.tripstore.proto.presentation.search

import android.os.Bundle
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentSearchBinding
import kr.tripstore.proto.presentation.base.DataBindingFragment
import timber.log.Timber

@AndroidEntryPoint
class SearchFragment : DataBindingFragment<FragmentSearchBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_search

    private val viewModel: SearchViewModel by viewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewModel = viewModel.apply {
            Timber.d("ViewModel: ${this.hashCode()}")
        }
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        viewModel.start()
    }

}
