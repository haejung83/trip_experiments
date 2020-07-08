package kr.tripstore.proto.shared.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@InstallIn(ApplicationComponent::class)
@Module
class CoroutineModule {

    @Provides
    @DefaultCoroutineDispatcher
    fun provideDefaultCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @IOCoroutineDispatcher
    fun provideIOCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @MainCoroutineDispatcher
    fun provideMainCoroutineDispatcher(): CoroutineDispatcher = Dispatchers.Main

}