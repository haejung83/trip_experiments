package kr.tripstore.proto.di

import dagger.MapKey
import kr.tripstore.proto.model.TripLinkType

@MapKey
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
annotation class ExecutableLinkResolverKey(val value: TripLinkType)