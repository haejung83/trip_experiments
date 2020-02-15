package kr.tripstore.proto.presentation.web

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentWebBinding
import kr.tripstore.proto.presentation.base.DaggerDataBindingFragment
import javax.inject.Inject

class WebFragment : DaggerDataBindingFragment<FragmentWebBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_web

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val args: WebFragmentArgs by navArgs()

    private val viewModel by viewModels<WebViewModel> { viewModelFactory }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewDataBinding.run {
            viewModel = this@WebFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
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
        viewModel.load(args.loadUrl)
    }

}