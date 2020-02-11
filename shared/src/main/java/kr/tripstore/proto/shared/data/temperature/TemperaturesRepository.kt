package kr.tripstore.proto.shared.data.temperature

import kr.tripstore.proto.shared.di.RemoteDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TemperaturesRepository @Inject constructor(
    @RemoteDataSource private val remoteDataSource: TemperaturesDataSource
) : TemperaturesDataSource by remoteDataSource