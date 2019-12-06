package kr.tripstore.proto.shared.di

import javax.inject.Scope

@Scope
@MustBeDocumented
@Target(
    AnnotationTarget.TYPE,
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION
)
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope