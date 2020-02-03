package kr.tripstore.proto.presentation.calendar

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import kr.tripstore.proto.shared.di.FragmentScope
import kr.tripstore.proto.shared.di.ViewModelKey

@Module
@Suppress("UNUSED")
internal abstract class CalendarModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun contributeCalendarFragment(): CalendarFragment

    @Binds
    @IntoMap
    @ViewModelKey(CalendarViewModel::class)
    abstract fun bindCalendarViewModel(viewModel: CalendarViewModel): ViewModel

}