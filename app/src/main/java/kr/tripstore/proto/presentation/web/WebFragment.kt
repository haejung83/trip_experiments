package kr.tripstore.proto.presentation.web

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentWebBinding
import kr.tripstore.proto.presentation.base.DaggerDataBindingFragment
import javax.inject.Inject

class WebFragment : DaggerDataBindingFragment<FragmentWebBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_web

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<WebViewModel> { viewModelFactory }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.run {
            viewModel = this@WebFragment.viewModel
            lifecycleOwner = this@WebFragment
        }
        // TODO : Assemble WebView's three parts - WebClient, WebChromeClient, Custom Javascript Interfaces
        viewDataBinding.webview.run {
            webChromeClient = WebContentChromeClient(viewModel)
            webViewClient = WebContentClient(viewModel)
            settings.apply {
                databaseEnabled = true
                domStorageEnabled = true
                javaScriptEnabled = true
            }
        }
        viewModel.load("https://www.google.com")
    }

    companion object {
        fun newInstance() = WebFragment()
    }

}