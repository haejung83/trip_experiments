package kr.tripstore.proto.presentation.search

import android.os.Bundle
import androidx.fragment.app.viewModels
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentSearchBinding
import kr.tripstore.proto.extension.getViewModelFactory
import kr.tripstore.proto.presentation.base.DataBindingFragment

class SearchFragment : DataBindingFragment<FragmentSearchBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_search

    private val viewModel by viewModels<SearchViewModel> { getViewModelFactory() }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.viewModel = viewModel
    }

    companion object {
        fun newInstance() = SearchFragment()
    }

}
