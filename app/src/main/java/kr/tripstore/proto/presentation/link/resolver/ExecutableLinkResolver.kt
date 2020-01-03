package kr.tripstore.proto.presentation.link.resolver

import kr.tripstore.proto.presentation.link.ExecutableLink

interface ExecutableLinkResolver {

    fun resolveExecutableLink(param: Map<String, String?>): ExecutableLink

}