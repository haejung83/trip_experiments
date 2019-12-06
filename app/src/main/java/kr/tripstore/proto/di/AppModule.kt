package kr.tripstore.proto.di

import android.content.Context
import dagger.Module
import dagger.Provides
import kr.tripstore.proto.TsApplication

@Module
class AppModule {

    @Provides
    fun provideContext(application: TsApplication): Context =
        application.applicationContext

}