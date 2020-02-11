package kr.tripstore.proto.shared.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

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