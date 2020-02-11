package kr.tripstore.proto.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import kr.tripstore.proto.TsApplication
import kr.tripstore.proto.shared.di.CoroutineModule
import kr.tripstore.proto.shared.di.SharedModule
import kr.tripstore.proto.shared.di.ViewModelModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBindingModule::class,
        ViewModelModule::class,
        SharedModule::class,
        CoroutineModule::class
    ]
)
interface AppComponent : AndroidInjector<TsApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: TsApplication): AppComponent
    }

}
