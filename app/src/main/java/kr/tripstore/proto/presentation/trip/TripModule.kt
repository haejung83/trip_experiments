package kr.tripstore.proto.presentation.trip

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import kr.tripstore.proto.shared.di.FragmentScope
import kr.tripstore.proto.shared.di.ViewModelKey

@Module
@Suppress("UNUSED")
internal abstract class TripModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeTripFragment(): TripFragment

    @Binds
    @IntoMap
    @ViewModelKey(TripViewModel::class)
    abstract fun bindTripViewModel(viewModel: TripViewModel): ViewModel

}