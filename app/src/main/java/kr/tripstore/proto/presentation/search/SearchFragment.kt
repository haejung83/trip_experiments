package kr.tripstore.proto.presentation.search

import android.os.Bundle
import kr.tripstore.proto.databinding.TripFragmentBinding
import kr.tripstore.proto.presentation.base.DataBindingFragment

class SearchFragment : DataBindingFragment<TripFragmentBinding>() {

    override val layoutResId: Int
        get() = TODO()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance() = SearchFragment()
    }

}
