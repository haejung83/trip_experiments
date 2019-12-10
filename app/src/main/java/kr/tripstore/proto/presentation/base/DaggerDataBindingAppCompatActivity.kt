package kr.tripstore.proto.presentation.base

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.support.DaggerAppCompatActivity

abstract class DaggerDataBindingAppCompatActivity<T : ViewDataBinding> : DaggerAppCompatActivity() {

    protected lateinit var viewDataBinding: T
        private set

    abstract val layoutResId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, layoutResId)
    }

}