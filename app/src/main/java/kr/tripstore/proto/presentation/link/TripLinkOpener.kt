package kr.tripstore.proto.presentation.link

import kr.tripstore.proto.model.TripLink
import kr.tripstore.proto.model.TripLinkType
import kr.tripstore.proto.presentation.link.resolver.ExecutableLinkResolver
import javax.inject.Inject
import javax.inject.Provider

class TripLinkOpener @Inject constructor(
    private val resolvers: @JvmSuppressWildcards Map<TripLinkType, Provider<ExecutableLinkResolver>>
) {

    fun open(tripLink: TripLink) {
        val targetResolver = resolvers[tripLink.type]?.get()
        val executableLink = targetResolver?.resolveExecutableLink(tripLink.parameters)
        executableLink?.execute()
    }

}