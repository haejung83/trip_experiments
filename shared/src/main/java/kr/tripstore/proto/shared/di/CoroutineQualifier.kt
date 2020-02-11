package kr.tripstore.proto.shared.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MainCoroutineDispatcher

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class IOCoroutineDispatcher

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DefaultCoroutineDispatcher
