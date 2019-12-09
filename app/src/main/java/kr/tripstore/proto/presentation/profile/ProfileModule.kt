package kr.tripstore.proto.presentation.profile

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import kr.tripstore.proto.shared.di.FragmentScope
import kr.tripstore.proto.shared.di.ViewModelKey

@Module
@Suppress("UNUSED")
internal abstract class ProfileModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeProfileFragment(): ProfileFragment

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindProfileViewModel(viewModel: ProfileViewModel): ViewModel

}