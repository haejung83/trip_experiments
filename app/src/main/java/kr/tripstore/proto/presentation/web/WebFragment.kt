package kr.tripstore.proto.presentation.web

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kr.tripstore.proto.R
import kr.tripstore.proto.databinding.FragmentWebBinding
import kr.tripstore.proto.presentation.base.DataBindingFragment

@AndroidEntryPoint
class WebFragment : DataBindingFragment<FragmentWebBinding>() {

    override val layoutResId: Int
        get() = R.layout.fragment_web

    private val args: WebFragmentArgs by navArgs()

    private val viewModel: WebViewModel by viewModels()

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