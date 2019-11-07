package kr.tripstore.proto.presentation.save

import android.os.Bundle
import kr.tripstore.proto.databinding.TripFragmentBinding
import kr.tripstore.proto.presentation.base.DataBindingFragment

class SaveFragment : DataBindingFragment<TripFragmentBinding>() {

    override val layoutResId: Int
        get() = TODO()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance() = SaveFragment()
    }

}
