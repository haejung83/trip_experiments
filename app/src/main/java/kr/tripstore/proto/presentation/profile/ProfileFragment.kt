package kr.tripstore.proto.presentation.profile

import android.os.Bundle
import kr.tripstore.proto.databinding.TripFragmentBinding
import kr.tripstore.proto.presentation.base.DataBindingFragment

class ProfileFragment : DataBindingFragment<TripFragmentBinding>() {

    override val layoutResId: Int
        get() = TODO()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance() = ProfileFragment()
    }

}
