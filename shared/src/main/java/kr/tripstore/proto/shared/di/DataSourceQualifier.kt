package kr.tripstore.proto.shared.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class RemoteTripDataSource

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class LocalTripDataSource

