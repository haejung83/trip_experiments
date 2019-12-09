package kr.tripstore.proto.presentation.search

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import kr.tripstore.proto.shared.di.FragmentScope
import kr.tripstore.proto.shared.di.ViewModelKey

@Module
@Suppress("UNUSED")
internal abstract class SearchModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeSearchFragment(): SearchFragment

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel

}