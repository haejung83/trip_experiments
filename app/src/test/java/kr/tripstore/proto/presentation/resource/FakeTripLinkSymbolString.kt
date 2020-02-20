package kr.tripstore.proto.presentation.resource

import kr.tripstore.proto.model.TripLinkType

class FakeTripLinkSymbolStringProvider : TripLinkSymbolStringProvider {

    override fun getSymbolByTripLinkType(tripLinkType: TripLinkType): String? {
        return "Fake"
    }

}