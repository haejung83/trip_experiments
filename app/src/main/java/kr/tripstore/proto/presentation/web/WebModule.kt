package kr.tripstore.proto.presentation.web

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import kr.tripstore.proto.shared.di.FragmentScope
import kr.tripstore.proto.shared.di.ViewModelKey

@Module
@Suppress("UNUSED")
internal abstract class WebModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeWebFragment(): WebFragment

    @Binds
    @IntoMap
    @ViewModelKey(WebViewModel::class)
    abstract fun bindWebViewModel(viewModel: WebViewModel): ViewModel

}