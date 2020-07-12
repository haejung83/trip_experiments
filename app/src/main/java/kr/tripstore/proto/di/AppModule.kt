package kr.tripstore.proto.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
class AppModule {
    /*
    Be replaced by @ApplicationContext annotation in Hilt
    @Provides
    fun provideContext(application: TsApplication): Context =
        application.applicationContext
    */
}