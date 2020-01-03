package kr.tripstore.proto.presentation.link.resolver

import kr.tripstore.proto.presentation.link.ExecutableLink
import javax.inject.Inject

class ThemeCalendarExecutableLinkResolver @Inject constructor() :
    ExecutableLinkResolver {

    override fun resolveExecutableLink(param: Map<String, String?>): ExecutableLink {
        // TODO: Build an executable link with params
        return ExecutableLink("Theme Calendar Executable Link")
    }

}