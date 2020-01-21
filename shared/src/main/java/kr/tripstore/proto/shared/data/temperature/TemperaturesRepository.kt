package kr.tripstore.proto.shared.data.temperature

import kr.tripstore.proto.shared.di.RemoteTripDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TemperaturesRepository @Inject constructor(
    @RemoteTripDataSource private val remoteDataSource: TemperaturesDataSource
) : TemperaturesDataSource by remoteDataSource