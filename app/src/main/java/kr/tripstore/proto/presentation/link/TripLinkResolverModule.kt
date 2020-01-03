package kr.tripstore.proto.presentation.link

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import kr.tripstore.proto.di.ExecutableLinkResolverKey
import kr.tripstore.proto.model.TripLinkType
import kr.tripstore.proto.presentation.link.resolver.ExecutableLinkResolver
import kr.tripstore.proto.presentation.link.resolver.ThemeCalendarExecutableLinkResolver
import kr.tripstore.proto.presentation.link.resolver.WebExecutableLinkResolver

@Module
@Suppress("UNUSED")
internal abstract class TripLinkResolverModule {

    @Binds
    @IntoMap
    @ExecutableLinkResolverKey(TripLinkType.WEB)
    abstract fun bindWebExecutableLinkResolver(
        executableLinkResolver: WebExecutableLinkResolver
    ): ExecutableLinkResolver

    @Binds
    @IntoMap
    @ExecutableLinkResolverKey(TripLinkType.THEME_CALENDAR)
    abstract fun bindThemeCalendarExecutableLinkResolver(
        executableLinkResolver: ThemeCalendarExecutableLinkResolver
    ): ExecutableLinkResolver

}