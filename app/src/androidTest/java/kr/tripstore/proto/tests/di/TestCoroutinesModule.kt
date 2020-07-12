package kr.tripstore.proto.tests.di

import android.os.AsyncTask
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kr.tripstore.proto.shared.di.DefaultCoroutineDispatcher
import kr.tripstore.proto.shared.di.IOCoroutineDispatcher
import kr.tripstore.proto.shared.di.MainCoroutineDispatcher


@InstallIn(ApplicationComponent::class)
@Module
object TestCoroutinesModule {

    @DefaultCoroutineDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher =
        AsyncTask.THREAD_POOL_EXECUTOR.asCoroutineDispatcher()

    @IOCoroutineDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher =
        AsyncTask.THREAD_POOL_EXECUTOR.asCoroutineDispatcher()

    @MainCoroutineDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    /*
    // Next time baby.
    @MainImmediateDispatcher
    @Provides
    fun providesMainImmediateDispatcher(): CoroutineDispatcher = Dispatchers.Main.immediate
    */
}