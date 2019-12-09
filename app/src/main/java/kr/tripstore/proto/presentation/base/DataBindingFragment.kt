package kr.tripstore.proto.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class DataBindingFragment<T : ViewDataBinding> : Fragment() {

    protected lateinit var viewDataBinding: T
        private set

    abstract val layoutResId: Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        DataBindingUtil.inflate<T>(inflater, layoutResId, container, false).apply {
            viewDataBinding = this
        }.root

}