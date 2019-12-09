package kr.tripstore.proto.presentation.save

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import kr.tripstore.proto.shared.di.FragmentScope
import kr.tripstore.proto.shared.di.ViewModelKey

@Module
@Suppress("UNUSED")
internal abstract class SaveModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeSaveFragment(): SaveFragment

    @Binds
    @IntoMap
    @ViewModelKey(SaveViewModel::class)
    abstract fun bindSaveViewModel(viewModel: SaveViewModel): ViewModel

}