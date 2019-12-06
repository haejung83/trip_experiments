package kr.tripstore.proto.shared.di

import dagger.Module
import dagger.Provides
import kr.tripstore.proto.shared.data.source.TripDataSource
import kr.tripstore.proto.shared.data.source.TripRepository
import kr.tripstore.proto.shared.data.source.remote.TripRemoteDataSource
import javax.inject.Singleton

@Module
class SharedModule {

    @Provides
    @RemoteTripDataSource
    fun provideTripDataSource(): TripDataSource = TripRemoteDataSource()


    @Singleton
    @Provides
    fun provideTripRepository(
        @RemoteTripDataSource remoteTripDataSource: TripDataSource
    ): TripRepository = TripRepository(remoteTripDataSource)

}