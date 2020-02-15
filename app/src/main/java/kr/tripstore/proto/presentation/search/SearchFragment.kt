package kr.tripstore.proto.presentation.search

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentSearchBinding
import kr.tripstore.proto.presentation.base.DaggerDataBindingFragment
import timber.log.Timber
import javax.inject.Inject

class SearchFragment : DaggerDataBindingFragment<FragmentSearchBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_search

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<SearchViewModel> { viewModelFactory }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewModel = viewModel.apply {
            Timber.d("ViewModel: ${this.hashCode()}")
        }
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        viewModel.start()
    }

    companion object {
        fun newInstance() = SearchFragment()
    }

}
